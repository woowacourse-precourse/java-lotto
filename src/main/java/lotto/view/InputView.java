package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.Constant;
import lotto.constant.ExceptionMessage;
import lotto.domain.Lotto;
import lotto.domain.LottoAnswer;

public class InputView {
    private int price;
    private List<Integer> lottoAnswerNumbers = new ArrayList<>();
    private int bonusNumber;

    private static final String INPUT_PRICE_STR = "구입금액을 입력해 주세요.\n";
    private static final String INPUT_ANSWER_STR = "당첨 번호를 입력해 주세요.\n";
    private static final String INPUT_BONUS_STR = "보너스 번호를 입력해 주세요.\n";

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
            if (tempPrice <= 0) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_PRICE_RANGE.getString());
            }
            if (tempPrice % Constant.UNIT_PRICE.getValue() != 0) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_PRICE_VALUE.getString());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_PRICE_TYPE.getString());
        }
    }

    public LottoAnswer getLottoAnswer() throws Exception {
        System.out.print(INPUT_ANSWER_STR);
        String userInputAnswer = Console.readLine();
        String[] inputAnswer = userInputAnswer.split(",");
        validateAnswer(inputAnswer);
        for (String numberChar : inputAnswer) {
            Integer parseInt = Integer.parseInt(numberChar);
            lottoAnswerNumbers.add(parseInt);
        }
        Lotto lottoAnswer = new Lotto(lottoAnswerNumbers);

        System.out.print(INPUT_BONUS_STR);
        String userInputBonus = Console.readLine();
        bonusNumber = Integer.parseInt(userInputBonus);
        return new LottoAnswer(lottoAnswer, bonusNumber);
    }

    private void validateAnswer(String[] inputAnswer) throws Exception {
        try {
            for (String numberChar : inputAnswer) {
                Integer.parseInt(numberChar);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_TYPE.getString());
        }
    }
}
