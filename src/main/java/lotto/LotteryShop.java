package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LotteryShop {
    public static int dollar;
    public static List<Lotto> my_lottery;
    public static List<Integer> winning_numbers;
    public static int bonus_number;

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
}
