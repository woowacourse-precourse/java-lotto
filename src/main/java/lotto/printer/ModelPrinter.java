package lotto.printer;

import java.util.ArrayList;
import java.util.List;
import lotto.score.Grade;
import lotto.score.Score;

public class ModelPrinter implements Printer {

    @Override
    public void print(PrinterText text) {

    }

    @Override
    public void print(PrinterFormat format, Object... params) {

    }

    @Override
    public void print(Object data) {
        Score score = (Score) data;
        List<Object> params = new ArrayList<>();

        for (Grade i : Grade.values()) {
            params.add(score.getGrade().get(i));
        }

        params.add(score.getRewardPercentage());

        String formedText = String.format(PrinterFormat.STATISTICS.getFormat(), params.toArray());
        System.out.println(formedText);
    }
}
