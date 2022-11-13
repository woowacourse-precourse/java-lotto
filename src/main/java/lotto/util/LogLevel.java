package lotto.util;

public enum LogLevel {

    ERROR("[ERROR] "),
    WARNING("[WARNING] "),
    INFO("[INFO] "),
    DEBUG("[DEBUG] "),
    TRACE("[TRACE] ");

    private String level;

    LogLevel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }
}
