package lotto.domain.game;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoView;
import lotto.util.View;

public class LottoGameView {
    
    public static void printPurchaseAmountInputMessage() {
        View.println("구입금액을 입력해 주세요.");
    }
    
    public static void printNormalNumberInputMessage() {
        View.println("당첨 번호를 입력해 주세요.");
    }
    
    public static void printBonusNumberInputMessage() {
        View.println("보너스 번호를 입력해 주세요.");
    }
    
    public static void printBoughtCount(List<Lotto> lottos) {
        View.println(lottos.size() + "개를 구매했습니다.");
    }
    
    public static void printNumbersByList(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            LottoView.printNumbersByArrayFormat(lotto);
        }
    }
}
