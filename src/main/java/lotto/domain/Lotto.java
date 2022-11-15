package lotto.domain;

import lotto.view.OutputView;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        checkInput(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            User.inputError(OutputView.validateMsg());
        }
    }

    public boolean isEqualNumber(List<Integer> numbers) {
        for (int i=0;i<numbers.size();i++) {
            isEqual(i,numbers);
        }
        return true;
    }

    public void isEqual(int i,List<Integer> numbers) {
        for(int j=0;j<i;j++) {
            if(numbers.get(i) == numbers.get(j)) {
                User.inputError(OutputView.equalMsg());
            }
        }
    }

    public boolean isRangeNumber(List<Integer> numbers) {
        for (int number : numbers) {
            if (!(number >= 1 && number <= 45)) {
                User.inputError(OutputView.rangeMsg());
            }
        }
        return true;
    }

    public void checkInput(List<Integer> num) {
        isEqualNumber(num);
        isRangeNumber(num);
        validate(num);
    }
}
