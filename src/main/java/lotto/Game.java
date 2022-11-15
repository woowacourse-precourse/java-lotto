package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static lotto.Validation.moneyValidate;

public class Game {
    private static List<Lotto> randomLottos;
    private static Lotto winningLotto;
    private static int bonusNumber;

    public void gameStart(){
        // 구매 금액 입력 및 타당성 검증
        String money = inputString("구입금액을 입력해 주세요.");
        int convertMoney = moneyValidate(money);
    }

    private String inputString(String message){
        System.out.println(message);
        String input = Console.readLine();

        return input;
    }

}
