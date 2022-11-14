package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LotteryShop {
    public static int dollar;
    public static List<Lotto> my_lottery;
    public static List<Integer> winning_numbers;
    public static int bonus_number;
    public static HashMap<Integer, Integer> my_result = new HashMap<>();
    public static int full_price = 0;

    public static String[] prints = new String[]{"3개 일치 (5,000원)", "4개 일치 (50,000원)", "5개 일치 (1,500,000원)", "5개 일치, 보너스 볼 일치 (30,000,000원)", "6개 일치 (2,000,000,000원)"};
    public static int[] prices = new int[]{5000, 50000, 1500000, 30000000, 2000000000};

    public static int get_number_of_tickets() {
        int number_of_tickets = dollar / 1000;
        if (dollar % 1000 != 0) throw new IllegalArgumentException();
        System.out.println(number_of_tickets + "개를 구매했습니다.");
        return number_of_tickets;
    }

    public static List<Lotto> generate_lottery(int number_of_tickets) {
        List<Lotto> tickets = new ArrayList<>();

        for (int i = 0; i < number_of_tickets; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            System.out.println(numbers);
            tickets.add(new Lotto(numbers));
        }

        return tickets;
    }

    public static void get_my_lottery() {
        int number_of_tickets = get_number_of_tickets();
        my_lottery = generate_lottery(number_of_tickets);
    }

    public static void get_result() {
        for (Lotto lotto : my_lottery) {
            lotto.get_matched(winning_numbers, bonus_number);
            if (6 > lotto.matched && lotto.matched > 2)
                my_result.put(8 - lotto.matched, my_result.getOrDefault(8 - lotto.matched, 0) + 1);
            if (lotto.matched == 6) {
                if (lotto.is_second_winner) {
                    my_result.put(2, my_result.getOrDefault(2, 0) + 1);
                    return;
                }
                my_result.put(1, my_result.getOrDefault(1, 0) + 1);
            }
        }
    }

    public static void print_result() {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i = 0; i < 5; i++) {
            int result = my_result.getOrDefault(5 - i, 0);
            System.out.println(prints[i] + " - " + result + "개");
            full_price += prices[i] * result;
        }
        System.out.println("총 수익률은 " + ((double) full_price / (double) dollar) * 100 + "%입니다.");
    }
}
