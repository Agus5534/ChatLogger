package io.github.agus5534;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * @author Agus5534
 * @version 1.0.4
 * @since 1.0.0
 * {@code ChatLogger chatLogger = new ChatLogger("permission_name");}
 */
public class ChatLogger {
    private String permission;
    private String author;
    private String content;
    private LogType logType;

    /**Create a ChatLog
     * Must specify a permission ({@link String})
     *
     * @param permission a {@link String} that specifies the permission which receives logs
     */
    public ChatLogger(String permission) {
        this.permission = permission;
    }
    /**
     * Send a basic vanilla Chat Log
     * <p>
     *  This method send a vanilla Chat Log
     * @param author Logger author
     * @param content Logger content
     * @see LogType
     */
    public void simple(String author, String content) {
        this.author = author;
        this.content = content;
        logType = LogType.SIMPLE;
        if(permission.isEmpty()) {
            logger();
        } else {
            loggerperm();
        }
    }
    /**
     * Send a severe Chat Log
     * <p>
     *  This method send a Red Chat Color! In most cases is for errors
     * @param author Logger author
     * @param content Logger content
     * @see LogType
     */
    public void severe(String author, String content) {
        this.author = author;
        this.content = content;
        logType = LogType.SEVERE;
        if(permission.isEmpty()) {
            logger();
        } else {
            loggerperm();
        }
    }
    /**
     * Send a warn Chat Log
     * <p>
     *  This method send a Yellow Chat Color! In most cases is for warnings or small problems
     * @param author Logger author
     * @param content Logger content
     * @see LogType
     */
    public void warn(String author, String content) {
        this.author = author;
        this.content = content;
        logType = LogType.WARN;
        if(permission.isEmpty()) {
            logger();
        } else {
            loggerperm();
        }
    }
    /**
     * Send a success Chat Log
     * <p>
     *  This method send a Green Chat Color! In most cases is for success execution
     * @param author Logger author
     * @param content Logger content
     * @see LogType
     */
    public void success(String author, String content) {
        this.author = author;
        this.content = content;
        logType = LogType.SUCCESS;
        if(permission.isEmpty()) {
            logger();
        } else {
            loggerperm();
        }
    }


    private void logger() {
        for(Player player : Bukkit.getOnlinePlayers()) {
            if(player.isOp()) {
                player.sendMessage(String.format(logType.getFormat(),author,content));
            }
        }
    }
    private void loggerperm() {
        for(Player player : Bukkit.getOnlinePlayers()) {
            if(player.hasPermission(permission)) {
                player.sendMessage(String.format(logType.getFormat(),author,content));
            }
        }
    }

}
