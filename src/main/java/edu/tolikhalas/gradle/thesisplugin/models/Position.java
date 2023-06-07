package edu.tolikhalas.gradle.thesisplugin.models;

public enum Position {
    DEVELOPER, MANAGER, DESIGNER, DEVOPS, HR;

    public static Position fromCode(String code) throws IllegalArgumentException {
        return switch (code) {
            case "developer" -> DEVELOPER;
            case "manager" -> MANAGER;
            case "designer" -> DESIGNER;
            case "devops" -> DEVOPS;
            case "hr" -> HR;
            default -> throw new IllegalArgumentException("Incorrect position: [" + code + "]");
        };
    }
}
