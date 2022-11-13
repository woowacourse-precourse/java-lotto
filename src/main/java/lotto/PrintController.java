package lotto;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.EnumMap;
import java.util.List;

public class PrintController {

    public void print(List<Lotto> lottoNumbers) {

        System.out.println(String.format(OutputMessage.PURCHASE_COUNT_MESSAGE.message,
                lottoNumbers.size()));

        lottoNumbers.forEach(lotto -> System.out.println(lotto.getLotto()));
    }

    public void print(EnumMap<WinPrize, Long> map) {
        System.out.println(String.format(OutputMessage.THREE_COUNT_MATCH_MESSAGE.message,
                map.getOrDefault(WinPrize.FIVE_GRADE, 0L)));
        System.out.println(String.format(OutputMessage.FOUR_COUNT_MATCH_MESSAGE.message,
                map.getOrDefault(WinPrize.FOUR_GRADE, 0L)));
        System.out.println(String.format(OutputMessage.FIVE_COUNT_MATCH_MESSAGE.message,
                map.getOrDefault(WinPrize.THREE_GRADE, 0L)));
        System.out.println(String.format(OutputMessage.BONUS_MATCH_MESSAGE.message,
                map.getOrDefault(WinPrize.TWO_GRADE, 0L)));
        System.out.println(String.format(OutputMessage.SIX_COUNT_MATCH_MESSAGE.message,
                map.getOrDefault(WinPrize.ONE_GRADE, 0L)));
    }

    public void print(double prizeRate) {

        // 소수점 둘째 자리에서 반올림
        System.out.println(String.format(OutputMessage.TOTAL_WIN_RATE_MESSAGE.message, prizeRate * 100));
    }

    public void printPurchaseMoneyMessage() {
        System.out.println(InputMessage.PURCHASE_MONEY_MESSAGE.message);
    }

    public void printWinNumberMessage() {
        System.out.println(InputMessage.WIN_NUMBER_MESSAGE.message);
    }

    public void printBonusNumberMessage() {
        System.out.println(InputMessage.BONUS_NUMBER_MESSAGE.message);
    }

    public void print(String message) {
        System.out.println(message);
    }
}
