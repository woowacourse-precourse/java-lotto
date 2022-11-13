package lotto.model;

import java.util.List;
import lotto.util.Validator;

public class LottoStore {
    private List<Integer> lotteryNumbers;
    private int bonusNumber;
    private Validator validator = new Validator();


    public LottoStore(List<Integer> numbers, int bonusNumber) {
        validator.validateNumbers(numbers);
        this.lotteryNumbers = numbers;
        validator.validateBonusNumber(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getLotteryNumbers() {
        return lotteryNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
