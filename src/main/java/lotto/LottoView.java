package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoController {
    private static void moneyValidation(int money){
        if(money % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 잘못된 금액입니다. 1000원 단위로 입력해 주세요");
        }
    }

    private static int buyPrice(){
        int money = Integer.parseInt(Console.readLine());
        moneyValidation(money);
        return money;
    }

    public static int howMany(){
        System.out.println("구입금액을 입력해 주세요.");
        int theNumberOfLotto = buyPrice() / 1000;
        return theNumberOfLotto;
    }


}
