package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class UI {
    private static final int BONUS_NUMBER_MATCHED = 7;

    public static List<Integer> enterWinningNumber() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        String[] split = input.split(",");
        try {
            Integer[] numbers = Arrays.stream(split).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
            return Arrays.asList(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자와 , 만 입력해주세요. ex)1,2,3,4,5,6");
        }
    }

    public static int enterCost(){
        System.out.println("구입금액을 입력해 주세요.");
        return Validation.validateCostType(Console.readLine());
    }

    public static void printBuyingLotto(int count, List<Lotto> lotteries) {
        System.out.println();
        System.out.println(count + "개를 구매했습니다.");
        for (Lotto lotto : lotteries) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            System.out.println(lottoNumbers);
        }
    }

    public static void printWinningHistory(Map<Integer, Integer> numberOfMatching, double profitRate) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        Prizecut[] prizecuts = Prizecut.values();
        for (int idx = 3; idx <=5; idx++) {
            System.out.println(idx + "개 일치 " + prizecuts[idx-3].getPrizePhrase() + " - " + numberOfMatching.get(idx) + "개");
        }

        System.out.println("5개 일치, 보너스 볼 일치 " + Prizecut.SECOND.getPrizePhrase() + " - " + numberOfMatching.get(BONUS_NUMBER_MATCHED) + "개");
        System.out.println("6개 일치 " + Prizecut.FIRST.getPrizePhrase() + " - " + numberOfMatching.get(6) + "개");
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }

    public static Integer enterBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
    }


}
