package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {

    static int get_consumption() {
        int consumption;
        System.out.println("구입금액을 입력해 주세요.");
        try{
            consumption = Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 올바른 입력 값이 아닙니다.");
        }
        if (consumption % 1000 != 0) throw new IllegalArgumentException("[ERROR] 입력 값이 1000으로 나눠떨어지지 않습니다.");
        return consumption;
    }

    static List<Integer> sort_ticket_num(List<Integer> numbers) {
        // Sort numbers.
        int[] sort_vehicle = new int[46];
        List<Integer> sort_result = new ArrayList<Integer>();
        for (int i = 0; i < numbers.size(); i++)
            sort_vehicle[numbers.get(i)] += 1;
        for (int i = 0; i < 46; i++)
            if (sort_vehicle[i] != 0)
                sort_result.add(i);
        return sort_result;
    }

    static List<Lotto> get_user_tickets(int count) {
        System.out.println(count + "개를 구매했습니다.");
        List<Lotto> ticket_list = new ArrayList<Lotto>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = sort_ticket_num(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            System.out.println(numbers);
            ticket_list.add(new Lotto(numbers));
        }
        return ticket_list;
    }

    static Lotto get_winning_number() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] win_num_input = Console.readLine().split(",");
        List<Integer> inputs = new ArrayList<Integer>();
        for (int i = 0; i < 6; i++) {
            inputs.add(Integer.parseInt(win_num_input[i]));
        }
        Lotto win_numbers = new Lotto(inputs);
        return win_numbers;
    }

    static int get_bonus_number() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus_num = Integer.parseInt(Console.readLine());
        if (bonus_num > 45 || bonus_num < 0) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return bonus_num;
    }

    static int get_match_cnt(List<Integer> user_numbers, List<Integer> win_numbers) {
        int[] dummy = new int[46];
        for (int i = 0; i < 6; i++) {
            dummy[user_numbers.get(i)] += 1;
        }
        int count = 0;
        for (int i = 0; i < 6; i++) {
            count += dummy[win_numbers.get(i)];
        }
        return count;
    }

    static int get_rank(List<Integer> user_numbers, List<Integer> win_numbers, int bonus) {
        int count = get_match_cnt(user_numbers,win_numbers);
        boolean bonus_match = false;
        for (int i = 0; i < 6; i++) {
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
        Double profit_rate = (Math.round((total_win_price * 1000 / consumption)) / 10.0);
        System.out.println("총 수익률은 " + profit_rate + "%입니다.");
    }


    public static void main(String[] args) {
        try {
            int consumption = get_consumption();

            List<Lotto> user_tickets = get_user_tickets(consumption / 1000);

            Lotto winning_number = get_winning_number();

            int bonus_number = get_bonus_number();

//         check result of get_winning_number and get_bonus_number
            int[] ranks = new int[10];
            for (int i = 0; i < user_tickets.size(); i++) {
                ranks[get_rank(user_tickets.get(i).getNumbers(), winning_number.getNumbers(), bonus_number)] += 1;
            }
            print_statistics(ranks, consumption);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
