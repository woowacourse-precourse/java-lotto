package lotto.controller;

import lotto.WinningStatus;

public class LottoControllerString {
    public static String INPUT_PURCHASE_PRICE =  "구입금액을 입력해 주세요.";
    public static String INPUT_LOTTO_NUMBRES = "당첨 번호를 입력해 주세요.";
    public static String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static String WINNING_STATISTICS = "당첨 통계\n ---";
    public static String purchaserMessage(int price){
        return String.format("%d개를 구매했습니다.", price);
    }

    public static String winningStatistic(int threeMatch, int fourMatch, int fiveMatch,
                                            int fiveAndBonusMatch, int sixMatch){
        return String.format(
                "%s - %d개\n", WinningStatus.MATCH_THREE, threeMatch,
                "%s - %d개\n", WinningStatus.MATCH_FOUR, fourMatch,
                "%s - %d개\n", WinningStatus.MATCH_FIVE, fiveMatch,
                "%s - %d개\n", WinningStatus.MATCH_FIVE_BONUS, fiveAndBonusMatch,
                "%s - %d개\n", WinningStatus.MATCH_SIX, sixMatch
        );
    }
    public static String winningRateMessage(double winningRate){
        return String.format("총 수익률은 %.1f% 입니다.",winningRate);
    }

}
