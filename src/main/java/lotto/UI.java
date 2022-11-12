package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.text.DecimalFormat;
import java.util.List;

public class UI {

    Domain domain = new Domain();
    DecimalFormat moneyFormatter = new DecimalFormat("###,###");
    public String getInputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public void printLottoNumber(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public String getInputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public String getInputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public void printWinningStats(List<Integer> rankList, int numberOfLottos) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i = 3; i < 8; i++) {
            System.out.println(i + "개 일치 (" + moneyFormatter.format(domain.getReward(8 - i)) + "원) - " + rankList.get(8 - i) + "개");
        }
        System.out.println("총 수익률은 " + domain.getYield(rankList, numberOfLottos) + "입니다.");
    }
}
