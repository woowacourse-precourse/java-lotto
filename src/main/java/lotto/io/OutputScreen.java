package lotto.io;

import java.text.DecimalFormat;

import lotto.resources.Sentence;

public class OutputScreen implements Output {

    @Override
    public void printOutput(String sentence) {
        System.out.println(sentence);
    }

    @Override
    public void printOutputComma(Double yieldPercantage) {
        DecimalFormat df1 = new DecimalFormat("#,##0.0");
        System.out.println(String.format(Sentence.TOTAL_YIELD.getValue(),
                df1.format(Double.parseDouble(Double.toString(yieldPercantage)))));
    }
}
