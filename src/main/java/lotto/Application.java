package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

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

    static int get_bonus_number() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus_num = Integer.parseInt(Console.readLine());
        if (bonus_num > 45 || bonus_num < 0) {
            throw new IllegalArgumentException();
        }
        return bonus_num;
    }

    static int get_rank(List<Integer> user_numbers, List<Integer> win_numbers, int bonus) {
        int count = 0;
        boolean bonus_match = false;
        for (int i = 0; i < 6; i++) {
            if (Objects.equals(user_numbers.get(i), win_numbers.get(i))) count += 1;
            if (bonus == user_numbers.get(i)) bonus_match = true;
        }
        if (count == 5) {
            if (bonus_match) return 2;
            return 3;
        }
        if (count == 6)
            return 1;
        return 8 - count;
    }

    static int get_total_win_price(int[] ranks) {
        return ranks[5] * 5000 + ranks[4] * 50000 + ranks[3] * 1500000 + ranks[2] * 30000000 + ranks[1] * 2000000000;
    }

    static void print_statistics(int[] ranks, int consumption) {
        int total_win_price = get_total_win_price(ranks);
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + ranks[5] + "개");
        System.out.println("4개 일치 (50,000원) - " + ranks[4] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + ranks[3] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + ranks[2] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + ranks[1] + "개");
        Double profit_rate = (Math.round(total_win_price / consumption * 10) / 10.0);
        System.out.println("총 수익률은 " + profit_rate + "%입니다.");
    }


    public static void main(String[] args) {
        // check result of get_winning_number and get_bonus_number
//        int[] ranks = new int[6];
//        for (int i = 0; i < user_tickets.size(); i++) {
//            ranks[get_rank(user_tickets.get(i).getNumbers(), winning_number.getNumbers(), bonus_number)] += 1;
//        }
    }
}
