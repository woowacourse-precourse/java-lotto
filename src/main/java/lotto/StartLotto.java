package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StartLotto {
    static int check_money(){
        String input_money;
        int money = 0;
        System.out.println("구입금액을 입력해 주세요");
        input_money = Console.readLine();
        if (input_money.isBlank()) throw new IllegalArgumentException("[ERROR] 구입금액을 입력해야 합니다.");
        try {
            money = Integer.parseInt(input_money);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자여야 합니다.");
        }
        if(money <= 0) throw new IllegalArgumentException("[ERROR] 구입금액이 0원이하 일 수 없습니다.");
        return money;
    }

    static int money2chance(int money){
        int chance;
        if(money % 1000 !=0) throw new IllegalArgumentException("[ERROR] 구입금액은 1000으로 나누어 떨어져야합니다.");
        chance = money/1000;
        System.out.println(chance + "개를 구매했습니다.");
        return chance;
    }
    static List<Integer> make_lotto_num(){
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1,45,6));
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }
    static List<List<Integer>> buy_lotto(int chance){
        List<List<Integer>> lotto_nums =new ArrayList<>();
        List<Integer> lotto;
        for(int i = 1 ; i <= chance ; i++){
            lotto = make_lotto_num();;
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
                throw new IllegalArgumentException("[ERROR] 당첨번호는 숫자여야 합니다.");
            }
        }
        return winning_num;
    }
    static List<Integer> read_winning(){
        List<Integer> winning_num;
        String num;
        String[] nums;

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
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1개의 숫자여야 합니다.");
        }
        return bonus;
    }


    public static void run() {
        // TODO: 프로그램 구현
        int money;
        int chance;
        List<List<Integer>> lotto_nums;
        List<Integer> winning_num;
        List<Integer> count_rank;
        int bonus;

        try {
            money = check_money();
            chance = money2chance(money);
            lotto_nums = buy_lotto(chance);
            winning_num = read_winning();
            Lotto lotto = new Lotto(winning_num);
            bonus = read_bonus();
            CheckNumber.check_bonus(lotto,bonus);
            CheckNumber.check_result(lotto, lotto_nums,bonus,money);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

}
