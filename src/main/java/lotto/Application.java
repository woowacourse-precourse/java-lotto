package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        int money = 0, num, bonus;
        int[] statistics = new int[5];
        double profit = 0, total = 0;
        List<Integer> win_numbers;
        List<Lotto> buy_lists = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            statistics[i] = 0;
        }

        System.out.println("구입금액을 입력해 주세요.");

        try {
            String input = Console.readLine();
            money = Lotto.check_input_validate(input);
        } catch (IllegalArgumentException e) {
            System.out.println(ExceptionMessage.NumbersOnly.getMsg());
        }

        try {
            if (money % 1000 != 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(ExceptionMessage.PurchaseUnit.getMsg());
        }

        num = money / 1000;

        System.out.println("\n" + num + "개를 구매했습니다.");

        for (int i = 0; i < num; i++) {
            List<Integer> buying_lotto = new ArrayList<>(Lotto.buy_lotto());
            buy_lists.add(new Lotto(buying_lotto));
        }

        for (Lotto list : buy_lists) {
            list.sort();
            System.out.println(list.getList());
        }

        System.out.println("\n당첨 번호를 입력해 주세요.");

        win_numbers = Arrays.stream(Console.readLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println("\n보너스 번호를 입력해 주세요.");

        bonus = Integer.parseInt(Console.readLine());

        for (Lotto buy_numbers : buy_lists) {
            boolean match = false;
            match = Lotto.check_bonus(buy_numbers, bonus);
            int match_num = Lotto.check_win(win_numbers, buy_numbers);
            if (match_num == 3) {
                statistics[0]++;
            }
            if (match_num == 4) {
                statistics[1]++;
            }
            if (match_num == 5 && match == false) {
                statistics[2]++;
            }
            if (match_num == 5 && match == true) {
                statistics[3]++;
            }
            if (match_num == 6) {
                statistics[4]++;
            }
        }

        System.out.println("\n당첨 통계\n---");

        System.out.println("3개 일치 (5,000원) - " + statistics[0] + "개");
        System.out.println("4개 일치 (50,000원) - " + statistics[1] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + statistics[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + statistics[3] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + statistics[4] + "개");

        profit = Lotto.check_profit(money, statistics, total) / money * 100.0;

        System.out.println("총 수익률은 " + Math.round(profit*10)/10.0 + "%입니다.");
    }
}