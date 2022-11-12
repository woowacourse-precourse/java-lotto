package lotto.model;

import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    OutputView outputView = new OutputView();
//    private final List<Integer> numbers;
//
//    public Lotto(List<Integer> numbers) {
//        validate(numbers);
//        this.numbers = numbers;
//    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            inputError(outputView.validateMsg());
        }
    }

    public List<Integer> change(String str) {
        List<Integer> num = new ArrayList<>();
        String[] splitStr = str.split(",");
        for (int i = 0; i < splitStr.length; i++) {
            num.add(Integer.valueOf(splitStr[i]));
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
                inputError(outputView.EqualMsg());
            }
        }
    }

    public boolean isRangeNumber(List<Integer> num) {
        for(int i=0;i<num.size();i++) {
            int number = num.get(i);
            if(!(number >= 1 && number <=45)) {
                inputError(outputView.RangeMsg());
            }
        }
        return true;
    }

    public void checkInput(List<Integer> num) {
        isEqualNumber(num);
        isRangeNumber(num);
        validate(num);
    }

    private void inputError(String error) {
        throw new IllegalArgumentException(error);
    }

}
