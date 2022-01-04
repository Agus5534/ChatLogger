package io.github.agus5534;

import org.bukkit.ChatColor;

public enum LogType {
    SIMPLE(ChatColor.GRAY + "" + ChatColor.ITALIC + "[%s: %s]"),
    WARN(ChatColor.YELLOW + "" + ChatColor.ITALIC + "[%s: %s]"),
    SEVERE(ChatColor.RED + "" + ChatColor.ITALIC + "[%s: %s]"),
    SUCCESS(ChatColor.GREEN + "" + ChatColor.ITALIC + "[%s: %s]");
    private String format;
    LogType(String format) {
        this.format = format;
    }
    public String getFormat() { return format; }
}
