package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        int money, num, bonus;
        int[] statistics = new int[5];
        double profit = 0;
        List<Integer> win_numbers;
        List<Lotto> buy_numbers = new ArrayList<>();

        System.out.println("구입금액을 입력해 주세요.");

        money = Integer.parseInt(Console.readLine());
        num = money / 1000;

        System.out.println("\n" + num + "개를 구매했습니다.");

        for (int i = 0; i < num; i++) {
            buy_numbers.add(new Lotto(Lotto.buy_lotto()));
        }

        System.out.println("\n당첨 번호를 입력해 주세요.");

        win_numbers = Arrays.stream(Console.readLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println("\n보너스 번호를 입력해 주세요.");

        bonus = Integer.parseInt(Console.readLine());

        System.out.println("\n당첨 통계\n---\n");

        System.out.println("3개 일치 (5,000원) - " + statistics[0] + "개");
        System.out.println("4개 일치 (50,000원) - " + statistics[1] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + statistics[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + statistics[3] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + statistics[4] + "개");

        System.out.println("총 수익률은 " + profit + "%입니다.");
    }
}
