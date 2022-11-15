package lotto.log;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class CustomLogFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        StringBuilder sb = new StringBuilder(1000);
        addLevel(sb, record.getLevel());
        addDateTime(sb, record.getMillis());
        addSourceMethodName(sb, record.getSourceMethodName());
        addErrorMessage(sb, record.getMessage());
        sb.append("\n");
        return sb.toString();
    }

    private void addLevel(StringBuilder sb, Level level) {
        sb.append("[");
        if (isSevere(level)) {
            sb.append("ERROR");
            sb.append("] ");
            return;
        }
        sb.append(level);
        sb.append("] ");
    }

    private boolean isSevere(Level level) {
        return level.equals(Level.SEVERE);
    }

    private void addDateTime(StringBuilder sb, long epochMillis) {
        sb.append(toDateTime(epochMillis));
    }

    private String toDateTime(long millis) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Instant.ofEpochMilli(millis)
                .atZone(ZoneId.systemDefault())
                .format(pattern);
    }

    private void addSourceMethodName(StringBuilder sb, String sourceMethodName) {
        sb.append(" [");
        sb.append(sourceMethodName);
        sb.append("] ");
    }

    private void addErrorMessage(StringBuilder sb, String message) {
        sb.append(message);
    }
}
