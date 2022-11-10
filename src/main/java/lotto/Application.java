package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {

    static int get_comsumption() {
        System.out.println("구입금액을 입력해 주세요.");
        int consumption = Integer.parseInt(Console.readLine());
        if (consumption % 1000 != 0)
            throw new IllegalArgumentException();
        return consumption;
    }

    static List<Lotto> get_user_tickets(int count) {
        List<Lotto> ticket_list = new ArrayList<Lotto>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            System.out.println(numbers.toString());
            ticket_list.add(new Lotto(numbers));
        }
        return ticket_list;
    }
    public static void main(String[] args) {


    }
}
