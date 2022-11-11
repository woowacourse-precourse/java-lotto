package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoAnswer;

public class InputController {
    private int price;
    private List<Integer> lottoAnswer = new ArrayList<>();
    private int bonusNumber;

    private static String INPUT_PRICE_STR = "구입금액을 입력해 주세요.\n";
    private static String INPUT_ANSWER_STR = "당첨 번호를 입력해 주세요.\n";
    private static String INPUT_BONUS_STR = "보너스 번호를 입력해 주세요.\n";

    public int getPrice() throws Exception {
        return inputPrice();
    }

    private int inputPrice() throws Exception {
        System.out.print(INPUT_PRICE_STR);
        String userInputPrice = Console.readLine();
        validateInputPrice(userInputPrice);
        price = Integer.parseInt(userInputPrice);
        return price;
    }

    private void validateInputPrice(String inputPrice) throws Exception {
        try {
            int tempPrice = Integer.parseInt(inputPrice);
            if (tempPrice % 1000 > 0) {
                throw new IllegalArgumentException("[ERROR]");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR]");
        }
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
