package lotto;


import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputController;

public class Application {


    public static void main(String[] args) {


        System.out.println("구입금액을 입력해 주세요.");
        String strBuyAmount = Console.readLine();
        InputController inputController = new InputController();
        Integer number = inputController.getBuyAmount(strBuyAmount);
        System.out.println(number);



    }
}
