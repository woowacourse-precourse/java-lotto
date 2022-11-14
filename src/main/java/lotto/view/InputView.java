package lotto.view;

import static lotto.domain.LottoValidator.validateLottoNumbers;
import static lotto.rule.LottoRange.isOutOfRange;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.exception.InputNotNumberException;
import lotto.exception.InvalidAmountValueException;
import lotto.exception.NumberOutOfRangeException;
import lotto.exception.NumbersDuplicatedException;
import lotto.exception.SmallAmountException;

public class InputView {

    public int inputAmount() {
        try {
            String input = Console.readLine();
            int amount = Integer.parseInt(input);

            validateAmount(amount);

            return amount;
        } catch (NumberFormatException e) {
            throw new InputNotNumberException(); // 커스텀 예외 필요
        }
    }

    public List<Integer> inputWinningNumbers() {
        try {
            String inputItems = Console.readLine();
            List<Integer> numbers = new ArrayList<>();
            String[] parsed = inputItems.split(","); // 파싱 오류가 발생할 일이 있을까 ?

            for (String s : parsed) {
                numbers.add(Integer.parseInt(s));
            }

            validateLottoNumbers(numbers);

            return numbers;
        } catch (NumberFormatException e) {
            throw new InputNotNumberException(); // 커스텀 예외 필요
        }
    }

    public int inputBonusNumber(List<Integer> numbers) {
        try {
            String input = Console.readLine();
            int bonusNumber = Integer.parseInt(input);

            validateBonusNumber(numbers, bonusNumber);

            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new InputNotNumberException();
        }
    }

    private void validateAmount(int amount) {
        isValidAmount(amount);
        isEnoughAmount(amount);
    }

    private void isValidAmount(int amount) { // 메소드명 수정 필요
        if (amount % 1000 != 0) {
            throw new InvalidAmountValueException();
        }
    }

    private void isEnoughAmount(int amount) { // 메소드명 수정 필요
        if (amount < 1000) {
            throw new SmallAmountException();
        }
    }

    private void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        validateBounsNumberOutOfRange(bonusNumber);
        validateBonusNumberDuplicated(numbers, bonusNumber);
    }

    private void validateBounsNumberOutOfRange(int bonusNumber) {
        if (isOutOfRange(bonusNumber)) {
            throw new NumberOutOfRangeException();
        }
    }

    private void validateBonusNumberDuplicated(List<Integer> numbers, int bonusNumber) {
        if (numbers.stream().anyMatch(number -> Collections.frequency(numbers, bonusNumber) >= 1)) {
            throw new NumbersDuplicatedException();
        }
    }
}
