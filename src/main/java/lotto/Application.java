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
        }

        return lotto_nums;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int money;
        int chance;
        List<List<Integer>> lotto_nums;
        money = check_money();
        chance = money2chance(money);
        lotto_nums = buy_lotto(chance);
    }
}
