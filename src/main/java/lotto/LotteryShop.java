package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LotteryShop {
    public static List<Lotto> generate_lottery(int number_of_tickets) {
        List<Lotto> tickets = new ArrayList<>();

        for (int i = 0; i < number_of_tickets; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            System.out.println(numbers);
            tickets.add(new Lotto(numbers));
        }

        return tickets;
    }
}
