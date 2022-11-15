package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.MapMatchPrize;

import java.util.LinkedHashMap;
import java.util.List;

public class Output {

    private static final String RATE_OF_PROFIT_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void printQuantity(int lottoQuantity) {
        System.out.println(System.lineSeparator() + lottoQuantity + OutputMessage.LOTTO_QUANTITY.getMessage());
    }

    public static void printAllLottoNumber(List<Lotto> lottoContainer) {
        for (Lotto lottoNumber : lottoContainer) {
            System.out.println(lottoNumber.getLotto());
        }
    }

    public static void printWinningStatics(LinkedHashMap<MapMatchPrize, Integer> winningResult) {
        System.out.printf(System.lineSeparator() + OutputMessage.WINNING_STATICS.getMessage());

        for (MatchMessage matchMessage : MatchMessage.values()) {
            System.out.printf(matchMessage.message() + "\n",
                    winningResult.get(MapMatchPrize.valueOf(matchMessage.toString())));
        }
    }

    public static void printRateOfProfit(double rateOfProfit) {
        System.out.printf(RATE_OF_PROFIT_MESSAGE, rateOfProfit);
    }
}
