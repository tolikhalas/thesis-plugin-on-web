package edu.tolikhalas.gradle.thesisplugin.plugin;

import org.apache.commons.codec.digest.DigestUtils;
import org.gradle.api.Action;
import org.gradle.api.DefaultTask;
import org.gradle.api.file.FileVisitDetails;
import org.gradle.api.tasks.InputDirectory;
import org.gradle.api.tasks.OutputDirectory;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class CalculateMd5Task extends DefaultTask {
    private File inputDir = new File(getProject().getProjectDir(), "src/main/resources/static");
    private File outputDir = new File(getProject().getBuildDir(), "hashsum");

    @InputDirectory
    public File getInputDir() {
        return inputDir;
    }

    public void setInputDir(File inputDir) {
        this.inputDir = inputDir;
    }

    @OutputDirectory
    public File getOutputDir() {
        return outputDir;
    }

    public void setOutputDir(File outputDir) {
        this.outputDir = outputDir;
    }

    @TaskAction
    public void calculateMd5() {
        getProject().fileTree(inputDir).visit(new Action<FileVisitDetails>() {
            @Override
            public void execute(FileVisitDetails details) {
                if (!details.getFile().isDirectory()) {
                    String relativePath = details.getRelativePath().getPathString();
                    File inputFile = details.getFile();
                    File outputFile = new File(outputDir, relativePath + ".md5");

                    if (!outputFile.exists() || inputFile.lastModified() > outputFile.lastModified()) {
                        outputFile.getParentFile().mkdirs();
                        try {
                            Files.write(outputFile.toPath(), DigestUtils.md5Hex(Files.readAllBytes(inputFile.toPath())).getBytes());
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        });
    }
}