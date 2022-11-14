package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserIO {

    public void printLottoNumbers(List<List<Integer>> lotto) {
        System.out.println(lotto.size()+"개를 구매했습니다.");
        for (List<Integer> paper : lotto) {
            System.out.println(paper);
        }
    }

    public Integer inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        Integer[] numbers = Arrays.stream(Console.readLine().split(","))
            .map(Integer::parseInt)
            .toArray(Integer[]::new);
        return new ArrayList<>(List.of(numbers));
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public void printWinStat() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " +  "개");
        System.out.println("4개 일치 (50,000원) - " +  "개");
        System.out.println("5개 일치 (1,500,000원) - " +  "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " +  "개");
        System.out.println("총 수익률은 " + "%입니다.");
    }

}
