package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class LottoView {

    public void printPurchaseAmountQuestion() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printMatchLottoNumberQuestion() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumberQuestion() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printPurchaseUnitCount(int purchaseCount) {
        System.out.println(String.format("%d개를 구매했습니다.", purchaseCount));
    }

    public <E> void printNestedList(List<List<E>> nestedList) {
        for(List<E> current : nestedList){
            System.out.println(current);
        }
    }

    private void printProfitRatio(BigDecimal profitRatio) {
        System.out.println("총 수익률은 " + profitRatio + "%입니다.");
    }

    private void printMatchInfo(Map<Lotto.MatchInfo, Integer> lottoStatics) {
        for (Lotto.MatchInfo key : lottoStatics.keySet()) {
            int value = lottoStatics.get(key);

            if (key == Lotto.MatchInfo.MATCH_FIVE_WITH_BONUS) {
                System.out.println(String.format("%d개 일치, 보너스 볼 일치 (%,d원) - %d개",
                        key.getMatchNumber(), key.getWinningAmount(), value));
            } else {
                System.out.println(String.format("%d개 일치 (%,d원) - %d개",
                        key.getMatchNumber(), key.getWinningAmount(), value));
            }
        }
    }

    public void printLottoStatics(Map<Lotto.MatchInfo, Integer> lottoStatics, BigDecimal profitRatio) {
        System.out.println("당첨 통계");
        System.out.println("---");

        this.printMatchInfo(lottoStatics);
        this.printProfitRatio(profitRatio);
    }

    public void printException(Exception e){
        System.out.println("[ERROR]"+ e.getMessage());
    }

    public String getUserInput() {
        return Console.readLine();
    }

}
