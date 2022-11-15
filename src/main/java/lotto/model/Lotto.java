package lotto.model;

import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto(String str) {
        List<Integer> numbers = change(str);
         checkInput(numbers);
         this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            User.inputError(OutputView.validateMsg());
        }
    }

    public List<Integer> change(String str) {
        List<Integer> num = new ArrayList<>();
        String[] splitStr = str.split(",");
        for (String s : splitStr) {
            num.add(Integer.valueOf(s));
        }
        return num;
    }

    public boolean isEqualNumber(List<Integer> num) {
        for (int i=0;i<num.size();i++) {
            isEqual(i,num);
        }
        return true;
    }

    public void isEqual(int i,List<Integer> num) {
        for(int j=0;j<i;j++) {
            if(num.get(i) == num.get(j)) {
                User.inputError(OutputView.equalMsg());
            }
        }
    }

    public boolean isRangeNumber(List<Integer> num) {
        for (int number : num) {
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
