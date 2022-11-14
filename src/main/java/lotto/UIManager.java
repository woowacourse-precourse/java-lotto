package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.ENUMS.Rank;
import lotto.ENUMS.UIMessages;

import java.util.List;
import java.util.Map;

public class UIManager {

    /**
     * 구매 금액 입력
     */
    public int enterPurchaseAmount() {
        System.out.println(UIMessages.ENTER_PURCHASE_AMOUNT.getText());
        return Integer.parseInt(Console.readLine());
    }

    /**
     * 구매한 로또 리스트 보여주기
     *
     * @param n
     * @param lottos
     */
    public void buyLottos(int n, List<Lotto> lottos) {
        System.out.println(n + UIMessages.BUY_LOTTOS.getText());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    /**
     * 당첨 번호 입력
     */
    public String enterWinningNumber() {
        System.out.println(UIMessages.ENTER_WINNING_NUMBER.getText());
        return Console.readLine();
    }

    /**
     * 보너스 번호 입력
     */
    public String enterBonusNumber() {
        System.out.println(UIMessages.ENTER_BONUS_NUMBER.getText());
        return Console.readLine();
    }

    /**
     * 당첨 통계
     */
    public void winningStat(User user) {
        System.out.println(UIMessages.WINNING_STATS.getText());
        Map<Rank, Integer> ranks = user.getRanks();
        for (Rank r : ranks.keySet()) {
            System.out.println(r.getCondition() + " ("
                    + String.format("%,d", r.getWinnings()) + UIMessages.WON.getText() +  ") - "
                    + ranks.get(r) + UIMessages.UNIT.getText());
        }
        System.out.println(UIMessages.TOTAL_EARNINGS.getText()
                + " " + user.getEarningsRate() + "%" + UIMessages.IS.getText());
    }
}
