package lotto.lotteryshop;

import lotto.input.InputAgent;
import lotto.validator.ValueValidator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        ValueValidator.validateInputLottoNumber(numbers);
    }

    public void inputLottoNumber() {
        InputAgent inputAgent = new InputAgent();
        for (String number : inputAgent.inputLottoNumbers()) {
            numbers.add(Integer.valueOf(number));
        }
    }

    public void inputBonusNumber() {
        InputAgent inputAgent = new InputAgent();
        numbers.add(inputAgent.inputBonusNumber());
    }
}
