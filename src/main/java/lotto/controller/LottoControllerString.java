package lotto.controller;

import lotto.WinningStatus;

public class LottoControllerString {
    public static String INPUT_PURCHASE_PRICE =  "구입금액을 입력해 주세요.";
    public static String INPUT_LOTTO_NUMBRES = "당첨 번호를 입력해 주세요.";
    public static String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static String WINNING_STATISTICS = "당첨 통계\n---";
    public static String UNMATCH_PRICE_UNIT = "[ERROR] 구입 금액은 천원 단위의 숫자 입니다.";
    public static String NUMBER_INPUT_ERROR = "[ERROR] 로또 번호는 6자리 1부터 45 사이의 숫자만으로 구성되어야 합니다.";
    public static String purchaserMessage(int price){
        return String.format("%d개를 구매했습니다.", price);
    }

    public static String winningStatistic(int threeMatch, int fourMatch, int fiveMatch,
                                            int fiveAndBonusMatch, int sixMatch){
        return String.format(
                "%s\n%s\n%s\n%s\n%s",
                String.format("%s - %d개",
                        WinningStatus.MATCH_THREE.getMessage(), threeMatch),
                String.format("%s - %d개",
                        WinningStatus.MATCH_FOUR.getMessage(), fourMatch),
                String.format("%s - %d개",
                        WinningStatus.MATCH_FIVE.getMessage(), fiveMatch),
                String.format("%s - %d개",
                        WinningStatus.MATCH_FIVE_BONUS.getMessage(), fiveAndBonusMatch),
                String.format("%s - %d개",
                        WinningStatus.MATCH_SIX.getMessage(), sixMatch)
        );
    }
    public static String winningRateMessage(double winningRate){
        return String.format("총 수익률은 %.1f% 입니다.",winningRate);
    }

}
