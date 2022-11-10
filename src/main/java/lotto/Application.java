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
        if (consumption % 1000 != 0) throw new IllegalArgumentException();
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

    static Lotto get_winning_number() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] win_num_input = Console.readLine().split(",");
        List<Integer> inputs = new ArrayList<Integer>();
        for (int i = 0; i < win_num_input.length; i++) {
            inputs.add(Integer.parseInt(win_num_input[i]));
        }
        Lotto win_numbers = new Lotto(inputs);

        return win_numbers;
    }

    public static void main(String[] args) {


    }
}
