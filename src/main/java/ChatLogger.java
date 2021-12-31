import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChatLogger {
    private String permission;
    private String author;
    private String content;
    private LogType logType;
    public ChatLogger(String permission) {
        this.permission = permission;
    }
    public ChatLogger() {}
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
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', String.format(logType.getFormat(),author,content)));
            }
        }
    }
    private void loggerperm() {
        for(Player player : Bukkit.getOnlinePlayers()) {
            if(player.hasPermission(permission)) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',String.format(logType.getFormat(),author,content)));
            }
        }
    }

}
