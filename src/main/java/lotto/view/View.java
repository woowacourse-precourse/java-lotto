package lotto.view;

import java.util.HashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class View {

    private static final int FIRST = 1;
    private static final int SECOND = 2;
    private static final int THIRD = 3;
    private static final int FORTH = 4;
    private static final int FIFTH = 5;

    // 로또 번호 비교한 모든 결과를 출력하는 메서드
    public void printResult (HashMap<Integer, Integer> prizeRankings, double totalProfit) {

        System.out.printf("3개 일치 (5,000원) - %d개\n", prizeRankings.get(FIFTH));
        System.out.printf("4개 일치 (50,000원) - %d개\n", prizeRankings.get(FORTH));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", prizeRankings.get(THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", prizeRankings.get(SECOND));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", prizeRankings.get(FIRST));
        System.out.printf("총 수익률은 %.1f%%입니다.\n", totalProfit*100);
    }

    // 생성된 로또 번호를 출력하는 메서드
    public void printUncheckedLotto (List<List<Integer>> usersLottos) {
        System.out.printf("%d개를 구매했습니다.\n", usersLottos.size());

        for (List<Integer> lotto: usersLottos) {
            System.out.println(lotto);
        }
    }

    // 보너스 번호를 입력하는 메서드
    public String inputBonusNumber () {
        System.out.println("보너스 번호를 입력해주세요.");

        return Console.readLine();
    }

    // 돈을 입력하는 메서드
    public String inputMoney () {
        System.out.println("구입 금액을 입력해주세요.");

        return Console.readLine();
    }

    // 로또 번호를 입력하는 메서드
    public  String inputLottoNumber () {
        System.out.println("당첨 번호를 입력해주세요.");

        return Console.readLine();
    }
}
