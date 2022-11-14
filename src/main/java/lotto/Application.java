package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        int money = 0, num, bonus = 0;
        int[] statistics = new int[5];
        double profit, total = 0;
        List<Integer> win_numbers = null;
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

        try {
            String input = Console.readLine();
            win_numbers = Arrays.stream(input.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            Lotto.checkDuplicate(new HashSet<>(win_numbers));
        } catch (IllegalArgumentException e) {
            System.out.println(ExceptionMessage.Duplicated.getMsg());
        }

        try {
            for (int number : win_numbers) {
                Lotto.checkValidation(number);
            }
            if (win_numbers.size() != 6) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(ExceptionMessage.NotValidateNum.getMsg());
        }

        System.out.println("\n보너스 번호를 입력해 주세요.");

        try {
            String input = Console.readLine();
            Lotto.check_input_validate(input);
            Lotto.checkValidation(Integer.parseInt(input));
            bonus = Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(ExceptionMessage.NotValidateBonusNum.getMsg());
        }

        Lotto.set_statistics(buy_lists, bonus, win_numbers, statistics);

        System.out.println("\n당첨 통계\n---");

        System.out.println("3개 일치 (5,000원) - " + statistics[0] + "개");
        System.out.println("4개 일치 (50,000원) - " + statistics[1] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + statistics[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + statistics[3] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + statistics[4] + "개");

        profit = Lotto.check_profit(statistics, total) / money * 100.0;

        System.out.println("총 수익률은 " + Math.round(profit*10)/10.0 + "%입니다.");
    }
}