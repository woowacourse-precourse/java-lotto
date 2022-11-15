package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static int getInputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        validateNum(input);
        int money = Integer.parseInt(input);
        validateInputMoney(money);
        return money;
    }

    public static void validateInputMoney(int inputMoney){
        if(inputMoney%1000 != 0){
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위여야 합니다.");
        }
    }
    public static void validateNum(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 외 문자가 입력되었습니다.");
        }
    }

    public static Lotto getInputAnswer(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] inputAnswer = Console.readLine().split(",");
        List<Integer> numbers = new ArrayList<>();
        for(String input : inputAnswer){
            validateNum(input);
            numbers.add(Integer.parseInt(input));
        }
        return new Lotto(numbers);

    }

    public static int getInputBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        validateNum(input);
        return Integer.parseInt(input);
    }


}
