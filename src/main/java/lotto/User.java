package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class User {

    public int money() {
        System.out.println("구입금액을 입력해 주세요");
        String money_input = Console.readLine();
        int money = Integer.MAX_VALUE;
        try {
            money = Integer.parseInt(money_input);
        } catch (IllegalArgumentException e) {
            System.out.println("[Error]" + e.getMessage());
            throw e;
        }
        return money;
    }

    public int num_lotto(int money) {
        int num = 0;
        num = money / 1000 ;
        if (money % 1000 != 0) {
            System.out.println("[Error]1,000 단위의 금액을 입력하세요");
            throw new IllegalArgumentException();
        }
        System.out.println(num +"개를 구매했습니다.");
        return num;
    }

    public List<Integer> lotto() {
        List<Integer> lotto = new ArrayList<>();
        while (lotto.size() < 6) {
            int randomNumber = Randoms.pickNumberInRange(1, 45);
            if (!lotto.contains(randomNumber)) {
                lotto.add(randomNumber);
            }
        }
        lotto.sort(Comparator.naturalOrder());
        return lotto;
    }

    public List<List<Integer>> generate_lotto(int num) {
        List<List<Integer>> all_lotto = new ArrayList<>();
        while (all_lotto.size() < num) {
            all_lotto.add(lotto());
        }

        for(int i = 0; i < all_lotto.size(); i++) {
            System.out.println(all_lotto.get(i));
        }
        return all_lotto;
    }

    public List<Integer> winning_number() {
        List<Integer> winning_number = new ArrayList<>();
        System.out.println("당첨번호를 입력해주세요");
        String winning_input = Console.readLine();
        try{
            String[] winning_array = winning_input.split(",");
            winning_number = Arrays.stream(winning_array).map(Integer::parseInt).collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            System.out.println("[Error]" + e.getMessage());
        }
        return winning_number;
    }

    public int bonus_number() {
        int bonus_number = Integer.MAX_VALUE;
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonus_input = Console.readLine();
        try{
            bonus_number = Integer.parseInt(bonus_input);
        } catch (IllegalArgumentException e) {
            System.out.println("[Error]" + e.getMessage());
        }
        return bonus_number;
    }


}
