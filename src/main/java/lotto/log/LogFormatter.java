package lotto.log;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogFormatter {


    public String format(Throwable e) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String date = LocalDateTime.now().format(dateFormat);

        StringBuilder sb = new StringBuilder();
        sb.append(date);
        sb.append(" [ERROR] ");
        sb.append(e.getMessage());
        sb.append("\n");

        for (StackTraceElement element : e.getStackTrace()) {
            sb.append(element.toString());
            sb.append("\n");
        }

        return sb.toString();
    }
}
