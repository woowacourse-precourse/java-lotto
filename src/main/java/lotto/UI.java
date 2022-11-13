package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class UI {
    private static int cost;

    public static List<Integer> enterWinningNumber() {
        String input = Console.readLine();
        String[] split = input.split(",");
        Integer[] numbers = Arrays.stream(split).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        return Arrays.asList(numbers);
    }

    public static int enterCost() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public static void printBuyingLotto(int count, List<Lotto> lotteries) {
        System.out.println();
        System.out.println(count + "개를 구매했습니다.");
        for (Lotto lotto : lotteries) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            System.out.println(lottoNumbers);
        }
    }

    public static Integer enterBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }

    public static int getCost() {
        return cost;
    }

    public static void setCost() {
        cost = Integer.parseInt(Console.readLine());
    }

}
