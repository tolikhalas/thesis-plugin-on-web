package edu.tolikhalas.gradle.thesisplugin.plugin;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class ThesisPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        project.getTasks().create("calculateMd5", CalculateMd5Task.class);
    }
}
