package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.message.ExceptionMessage;
import lotto.validate.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputHandler {

    public int inputMoney() {
        int money = 0;
        try {
            money = Integer.parseInt(Console.readLine());
            Validator.validatePrice(money);
        } catch (NumberFormatException e) {
            System.out.println(ExceptionMessage.ERROR_FORMAT.getMessage());
            throw new IllegalArgumentException(ExceptionMessage.ERROR_FORMAT.getMessage());
        }

        return money;
    }

    public List<Integer> inputLottoNumber() {
        List<Integer> numbers;
        try {
            String[] splitNumber = Console.readLine().split(",");
            numbers = Arrays.stream(splitNumber)
                    .map(Integer::parseInt)
                    .sorted()
                    .collect(Collectors.toList());
            Validator.validateNumbers(numbers);
        } catch (NumberFormatException e) {
            System.out.println(ExceptionMessage.ERROR_FORMAT.getMessage());
            throw new IllegalArgumentException(ExceptionMessage.ERROR_FORMAT.getMessage());
        }

        return numbers;
    }

    public int inputLottoBonusNumber(Lotto winningLotto) {
        int bonusNumber = Integer.parseInt(Console.readLine());
        Validator.validateBonusNumber(bonusNumber, winningLotto);

        return bonusNumber;
    }
}
