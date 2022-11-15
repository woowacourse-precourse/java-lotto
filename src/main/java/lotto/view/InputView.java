package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.Constant;
import lotto.constant.ExceptionMessage;
import lotto.constant.PrintMessage;
import lotto.domain.Lotto;
import lotto.domain.LottoAnswer;

public class InputView {
    private int price;
    private List<Integer> lottoAnswerNumbers = new ArrayList<>();
    private int bonusNumber;

    public int getPrice() throws Exception {
        return inputPrice();
    }

    private int inputPrice() throws Exception {
        System.out.print(PrintMessage.INPUT_PRICE.getString());
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
        System.out.print(PrintMessage.INPUT_ANSWER.getString());
        String userInputAnswer = Console.readLine();
        String[] inputAnswer = userInputAnswer.split(",");
        validateAnswerType(inputAnswer);
        for (String numberChar : inputAnswer) {
            Integer parseInt = Integer.parseInt(numberChar);
            lottoAnswerNumbers.add(parseInt);
        }
        Lotto lottoAnswer = new Lotto(lottoAnswerNumbers);

        System.out.print(PrintMessage.INPUT_BONUS.getString());
        String userInputBonus = Console.readLine();
        validateBonusType(userInputBonus);
        bonusNumber = Integer.parseInt(userInputBonus);
        return new LottoAnswer(lottoAnswer, bonusNumber);
    }

    private void validateAnswerType(String[] inputAnswer) throws Exception {
        try {
            for (String numberChar : inputAnswer) {
                Integer.parseInt(numberChar);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_TYPE.getString());
        }
    }

    private void validateBonusType(String inputBonus) throws Exception {
        try {
            Integer.parseInt(inputBonus);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BONUS_TYPE.getString());
        }
    }
}
