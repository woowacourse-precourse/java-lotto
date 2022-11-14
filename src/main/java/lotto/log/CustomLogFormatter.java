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
        sb.append("[");
        if (isSevere(record.getLevel())) {
            sb.append("ERROR");
        } else {
            sb.append(record.getLevel());
        }
        sb.append("] ");
        sb.append(toDateTime(record.getMillis()));
        sb.append(" [");
        sb.append(record.getSourceMethodName());
        sb.append("] ");
        sb.append(record.getMessage());
        sb.append("\n");
        return sb.toString();
    }

    private boolean isSevere(Level level) {
        return level.equals(Level.SEVERE);
    }

    private String toDateTime(long millis) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Instant.ofEpochMilli(millis)
                .atZone(ZoneId.systemDefault())
                .format(pattern);
    }
}
