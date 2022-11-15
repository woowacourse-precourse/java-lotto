package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Map;

public class UserInterface {

    public static int inputMoney(){
        String input;
        int money = 0;

        System.out.println("구입 금액을 입력해 주세요.");
        input = Console.readLine();
        money = onlyNumberInput(input);
        checkDividedOneThousand(money);

        return money;
    }

    public static void checkDividedOneThousand(int money){
        if(money % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000으로 나누어 떨어져야 합니다.");
        }
    }

    public static int onlyNumberInput(String input){
        try{
            int money;
            money = Integer.parseInt(input);
            return money;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 구입 금액은 숫자를 입력해야 합니다.");
            return 0;
        }
    }

}
