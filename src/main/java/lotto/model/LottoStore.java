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

    public void compareLotto(Lotto inputLotto) {
        int sameNumbers = countSameNumbers(inputLotto.getNumbers());
        inputLotto.setSameNumbers(sameNumbers);

        boolean sameBonusNumber = inputLotto.getNumbers().contains(bonusNumber);
        inputLotto.setSameBonusNumber(sameBonusNumber);
    }

    public int countSameNumbers(List<Integer> numbers) {
        int count = 0;
        for (int number : numbers) {
            if (lotteryNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }
}
