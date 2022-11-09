package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoAnswer;

public class InputController {
    private int price;
    private static String INPUT_STR = "구입금액을 입력해 주세요.";

    public int getPrice() {
        return inputPrice();
    }

    private int inputPrice() {
        System.out.print(INPUT_STR);
        String userInputPrice = Console.readLine();
        price = Integer.parseInt(userInputPrice);
        validatePrice(price);
        return price;
    }

    private void validatePrice(int price) {

    }

    public LottoAnswer getLottoAnswer() {
        return null;
    }
}
