package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class UserIO {

    public static void printLottoNumbers(List<Lotto> allLotto) {
        System.out.println(allLotto.size()+"개를 구매했습니다.");
        for (Lotto paper : allLotto) {
            System.out.println(paper.getNumbers());
        }
    }

    public static Integer inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Validaor.validatePurchaseAmount(Console.readLine());
    }

    public static List<Integer> inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();

        return Validaor.validateWinningNumbers(input);
    }

    public static Integer inputBonusNumber(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해주세요.");
        String input = Console.readLine();
        return Validaor.validateBonusNumber(input, winningNumbers);
    }

    public static void printWinStat(Map<Rank, Integer> map, Double yield) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + map.getOrDefault(Rank.FIFTH, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + map.getOrDefault(Rank.FOURTH, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + map.getOrDefault(Rank.THIRD, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + map.getOrDefault(Rank.SECOND, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + map.getOrDefault(Rank.FIRST, 0) + "개");
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }

}
