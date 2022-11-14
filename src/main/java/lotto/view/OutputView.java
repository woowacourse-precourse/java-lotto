package lotto.view;

import lotto.model.Lotto;

import java.text.DecimalFormat;
import java.util.List;

public class OutputView {
    private OutputView() {
    }

    public static OutputView getInstance() {
        return new OutputView();
    }

    public void print(String sentence) {
        System.out.println(sentence);
    }

    public void printInputPurchaseMoneySentence() {
        print(OutputConstants.INPUT_PURCHASE_MONEY_SENTENCE);
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void printOutputNumberOfPurchaseLotto(int numberOfLotto) {
        String output = String.format(OutputConstants.OUTPUT_NUMBER_OF_PURCHASE_LOTTO, numberOfLotto);
        print(output);
    }

    public void printInputWinningNumbersSentence() {
        print(OutputConstants.INPUT_WINNING_NUMBERS_SENTENCE);
    }

    public void printInputBonusNumberSentence() {
        print(OutputConstants.INPUT_BONUS_NUMBER_SENTENCE);
    }

    public void printOutputWinningStatisticsSentence() {
        print(OutputConstants.OUTPUT_WINNING_STATISTICS_SENTENCE);
    }

    public void printOutputContour() {
        print(OutputConstants.OUTPUT_CONTOUR);
    }

    public void printOutputEarningRate(double earningRate) {
        DecimalFormat df = new DecimalFormat("###,###.0");
        String earningRateForm = df.format(earningRate);

        String earning = String.format(OutputConstants.OUTPUT_EARNING_RATE, earningRateForm);
        print(earning);
    }

    public void printNewLine() {
        print("");
    }
}
