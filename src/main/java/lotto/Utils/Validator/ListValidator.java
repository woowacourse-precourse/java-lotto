package lotto.Utils.Validator;


import lotto.Utils.Converter;
import lotto.View.OutputView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListValidator {



    public static void validateRange(String StringNumber) {
        int number = Integer.parseInt(StringNumber);
        if (!(number > 0 && number < 46)) {
            OutputView.errorMessage("입력값의 범위가 맞지 않습니다..");
            throw new IllegalArgumentException();
        }
    }

    public static void Overlaped(String[] stringArray) {
        List<Integer> List = Converter.stringArrayToIntegerList(stringArray);
        Set<Integer> numSet = new HashSet<>(List);

        if (numSet.size() != List.size()) {
            OutputView.errorMessage("중복되는 값이 있습니다.");
            throw new IllegalArgumentException();
        }
    }



    public static void length(List<Integer> numbers) {
        if (numbers.size() != 6) {
            OutputView.errorMessage("당첨번호의 길이가 올바르지 않습니다.");
            throw new IllegalArgumentException();
        }
    }


}
