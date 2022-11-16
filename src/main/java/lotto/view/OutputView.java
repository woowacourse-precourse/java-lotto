package lotto.view;

import lotto.model.Lottos;
import lotto.model.LottosResult;

public class OutputView {
    private static final String NUMBER_OF_PURCHASED_LOTTOS_MESSAGE_FORMAT = "\n%d개를 구매했습니다.\n";
    private static final String PROFIT_RATE_MESSAGE_FORMAT = "총 수익률은 %.1f%%입니다.\n";
    private static final int ONE_DECIMAL_POINT_CONVERTER = 10;
    private static OutputView instance;

    private OutputView() {
    }

    public static OutputView getInstance() {
        if (instance == null) {
            instance = new OutputView();
        }

        return instance;
    }

    public void printNumberOfLottos(int numberOfLottos) {
        System.out.printf(NUMBER_OF_PURCHASED_LOTTOS_MESSAGE_FORMAT, numberOfLottos);
    }

    public void printLottos(Lottos lottos) {
        System.out.println(lottos);
    }

    public void printLottosResult(LottosResult lottosResult) {
        System.out.print(lottosResult);
    }

    public void printProfitRate(double profitRate) {
        System.out.printf(PROFIT_RATE_MESSAGE_FORMAT, roundToOneDecimalPlace(profitRate));
    }

    private double roundToOneDecimalPlace(double profitRate) {
        return (double) Math.round(profitRate * ONE_DECIMAL_POINT_CONVERTER) / ONE_DECIMAL_POINT_CONVERTER;
    }
}
