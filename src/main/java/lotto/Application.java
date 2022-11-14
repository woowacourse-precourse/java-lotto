package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            LotteryShop.dollar = get_dollar();
            LotteryShop.get_my_lottery();
            LotteryShop.winning_numbers = get_winning_number();
            LotteryShop.bonus_number = get_bonus_number();
            LotteryShop.get_result();
            LotteryShop.print_result();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static int get_dollar() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR]잘못된 입력입니다!");
        }
    }

    public static int get_bonus_number() {
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR]잘못된 입력입니다!");
        }
    }

    public static List<Integer> get_winning_number() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String lottery_number = Console.readLine();
        String[] test = lottery_number.split(",");
        List<Integer> result = new ArrayList<>();
        for (String i : test) {
            try {
                result.add(Integer.parseInt(i));
            } catch (Exception e) {
                throw new IllegalArgumentException("[ERROR]잘못된 입력입니다!");
            }
        }
        HashSet<Integer> hash_result = new HashSet<>(result);
        if (hash_result.size() != 6) throw new IllegalArgumentException("[ERROR]잘못된 입력입니다!");
        return result;
    }
}
