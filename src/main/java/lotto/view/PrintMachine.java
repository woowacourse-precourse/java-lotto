package lotto.view;

import lotto.domain.LottoPaper;

import java.util.List;

public class PrintMachine {
    private static final String volume = "개";
    public static void askPriceToBuy(){
        System.out.println("구입금액을 입력해 주세요.");
    }
    public static void volumeBuying(long volume){
        System.out.println(volume + "개를 구매했습니다.");
    }
    public static void askWinningNumber()
    {
        System.out.println("당첨 번호를 입력해 주세요.");
    }
    public static void askBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }
    public static void printStatics(){
        System.out.println("당첨 통계\n---");
    }
    public static void winningResult(long [] countResult)
    {
        printStatics();
        System.out.println(WinningMessage.THIRD_MATCH.getMessage() + countResult[3] + volume);
        System.out.println(WinningMessage.FORTH_MATCH.getMessage() + countResult[4] + volume);
        System.out.println(WinningMessage.FIFTH_MATCH.getMessage() + countResult[5] + volume);
        System.out.println(WinningMessage.BONUS_MATCH.getMessage() + countResult[7] + volume);
        System.out.println(WinningMessage.SIXTH_MATCH.getMessage() + countResult[6] + volume);
    }
    public static void yieldOfLotto(String value){
        System.out.println("총 수익률은 " + value + "%입니다.");
    }
    public static void printLottoPapers(List<LottoPaper> lottoPapers) {
        for (LottoPaper lottoPaper : lottoPapers) {
            System.out.println(lottoPaper.lottoNumber);
        }
    }
}
