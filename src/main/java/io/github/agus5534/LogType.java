package io.github.agus5534;

public enum LogType {
    SIMPLE("&7&o[%s: %s]"),
    WARN("&g&o[%s: %s]"),
    SEVERE("&c&o[%s: %s]"),
    SUCCESS("&a&o[%s: %s]");

    private String format;
    LogType(String format) {
        this.format = format;
    }
    public String getFormat() { return format; }
}
