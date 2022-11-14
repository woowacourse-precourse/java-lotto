package lotto;

import java.util.List;

public class PrintMachine {
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
    public static void winningResult(long [] countResult)
    {
        System.out.println(WinningMessage.STATICS.getMessage());
        System.out.println(WinningMessage.THIRD_MATCH.getMessage() + countResult[3]+ WinningMessage.VOLUME.getMessage());
        System.out.println(WinningMessage.FORTH_MATCH.getMessage() + countResult[4]+ WinningMessage.VOLUME.getMessage());
        System.out.println(WinningMessage.FIFTH_MATCH.getMessage() + countResult[5] + WinningMessage.VOLUME.getMessage());
        System.out.println(WinningMessage.BONUS_MATCH.getMessage() + countResult[7] + WinningMessage.VOLUME.getMessage());
        System.out.println(WinningMessage.SIXTH_MATCH.getMessage() + countResult[6] + WinningMessage.VOLUME.getMessage());
    }
    public static void yieldOfLotto(double value){
        System.out.println("총 수익률은 " + (float)value + "%입니다.");
    }
    public static void printLottoPapers(List<LottoPaper> lottoPapers) {
        for (LottoPaper lottoPaper : lottoPapers) {
            System.out.println(lottoPaper.lottoNumber);
        }
    }
}
