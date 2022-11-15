package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static List<Integer> inputConversion(String input) {
        String[] nums = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String num:nums) {
            try {
                numbers.add(Integer.parseInt(num));
            } catch (Exception e){
                throw new IllegalArgumentException("[Error] 로또 숫자는 Integer 이어야 합니다.");
            }
        }
        return numbers;
    }
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        Integer amount;
        try {
            amount = Integer.valueOf(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("구매 금액은 숫자여야 합니다.");
        }

        Lotto.checkBuyAmount(amount);
        amount = amount/1000;
        List<List<Integer>> lottos = Lotto.generateLotto(amount);

        //로또 당첨 번호 입력 받기
        System.out.println("당첨 번호를 입력해 주세요.");
        Lotto firstPlace = new Lotto(inputConversion(Console.readLine()));
        
    }
}
