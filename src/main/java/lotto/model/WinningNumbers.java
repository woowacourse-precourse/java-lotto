package lotto.model;

import lotto.util.validator.LottoValidator;

import java.util.List;

public class WinningNumbers {
    private List<Integer> numbers;
  //  private final int bonusNumber;

    public WinningNumbers(List<Integer> numbers) {
        new LottoValidator(numbers);
        this.numbers = numbers;
       // this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

//    public int getBonusNumber() {
//        return this.bonusNumber;
//    }
}
