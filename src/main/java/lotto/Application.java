package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Application {
    static int check_money(){
        String input_money;
        int money;
        System.out.println("구입금액을 입력해 주세요");
        input_money = Console.readLine();
        if (input_money.isBlank()) throw new IllegalArgumentException();
        try {
            money = Integer.parseInt(input_money);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }
        return money;
    }

    static int money2chance(int money){
        int chance;
        if(money % 1000 !=0) throw new IllegalArgumentException();
        chance = money/1000;
        System.out.println(chance + "개를 구매했습니다.");
        return chance;
    }
    static List<Integer> make_lotto_num(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }
    static List<List<Integer>> buy_lotto(int chance){
        List<List<Integer>> lotto_nums =new ArrayList<>();
        List<Integer> lotto;
        for(int i = 1 ; i <= chance ; i++){
            lotto = make_lotto_num();
            lotto_nums.add(lotto);
            System.out.println(lotto);
        }

        return lotto_nums;
    }

    static List<Integer> check_winning(String[] nums){
        List<Integer> winning_num = new ArrayList<Integer>();
        int num;
        for (int i = 0;i < nums.length;i++){
            try {
                num = Integer.parseInt(nums[i]);
                winning_num.add(num);
            } catch (NumberFormatException ex) {
                throw new IllegalArgumentException();
            }
        }
        return winning_num;
    }
    static List<Integer> read_winning(){
        List<Integer> winning_num;
        String num;
        String[] nums;
        int temp;

        System.out.println("당첨 번호를 입력해 주세요.");

        num = Console.readLine();
        nums = num.split(",");
        winning_num = check_winning(nums);

        return winning_num;
    }

    static int read_bonus(){
        String input_num;
        int bonus;
        System.out.println("보너스 번호를 입력해 주세요.");
        input_num = Console.readLine();
        try {
            bonus = Integer.parseInt(input_num);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }
        return bonus;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int money;
        int chance;
        List<List<Integer>> lotto_nums;
        List<Integer> winning_num;
        int bonus;

        money = check_money();
        chance = money2chance(money);
        lotto_nums = buy_lotto(chance);
        winning_num = read_winning();
        bonus = read_bonus();
    }
}
