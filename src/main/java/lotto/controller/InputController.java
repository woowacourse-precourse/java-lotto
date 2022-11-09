package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoAnswer;

public class InputController {
    private int price;
    private List<Integer> lottoAnswer = new ArrayList<>();
    private int bonusNumber;

    private static String INPUT_PRICE_STR = "구입금액을 입력해 주세요.";
    private static String INPUT_ANSWER_STR = "당첨 번호를 입력해 주세요.";
    private static String INPUT_BONUS_STR = "보너스 번호를 입력해 주세요.";

    public int getPrice() {
        return inputPrice();
    }

    private int inputPrice() {
        System.out.print(INPUT_PRICE_STR);
        String userInputPrice = Console.readLine();
        price = Integer.parseInt(userInputPrice);
        validatePrice(price);
        return price;
    }

    private void validatePrice(int price) {

    }

    public LottoAnswer getLottoAnswer() {
        System.out.print(INPUT_ANSWER_STR);
        String userInputAnswer = Console.readLine();
        String[] inputAnswer = userInputAnswer.split(",");
        validateAnswer(inputAnswer);
        for (String numberChar : inputAnswer) {
            Integer parseInt = Integer.parseInt(numberChar);
            lottoAnswer.add(parseInt);
        }

        System.out.print(INPUT_BONUS_STR);
        String userInputBonus = Console.readLine();
        bonusNumber = Integer.parseInt(userInputBonus);
        return new LottoAnswer(lottoAnswer, bonusNumber);
    }

    private void validateAnswer(String[] inputAnswer) {
    }
}
