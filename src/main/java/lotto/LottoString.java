package lotto;

import lotto.WinningStatus;

public class LottoString {
    public static String INPUT_PURCHASE_PRICE =  "구입금액을 입력해 주세요.";
    public static String INPUT_LOTTO_NUMBRES = "\n당첨 번호를 입력해 주세요.";
    public static String INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";
    public static String WINNING_STATISTICS = "\n당첨 통계\n---";

    public static String purchaseMessage(Integer price){
        return String.format("\n%d개를 구매했습니다.", price/1000);
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
        return  "총 수익률은 "+winningRate*100 + "%입니다.";
    }
}
