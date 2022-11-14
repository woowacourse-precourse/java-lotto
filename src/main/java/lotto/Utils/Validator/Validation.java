package lotto.Utils.Validator;


import lotto.View.OutputView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {

    public static void Integer(String string) {
        if (!string.matches("-?\\d+")) {
            OutputView.errorMessage("입력값이 옳지 않습니다.");
            throw new IllegalArgumentException();
        }
    }

    public static void validateRange(String StringNumber) {
        int number = Integer.parseInt(StringNumber);
        if (!(number > 0 && number < 46)) {
            OutputView.errorMessage("입력값의 범위가 맞지 않습니다..");
            throw new IllegalArgumentException();
        }
    }

    public static void Overlaped(String[] stringArray) {
        List<Integer> List = stringArrayToIntegerList(stringArray);
        Set<Integer> numSet = new HashSet<>(List);

        if (numSet.size() != List.size()) {
            OutputView.errorMessage("중복되는 값이 있습니다.");
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> stringArrayToIntegerList(String[] inputString) {
        List<Integer> inputList = new ArrayList<Integer>();

        for (String s : inputString) {
            inputList.add(Integer.parseInt(s));
        }
        return inputList;
    }

    public static void length(List<Integer> numbers) {
        if (numbers.size() != 6) {
            OutputView.errorMessage("당첨번호의 길이가 올바르지 않습니다.");
            throw new IllegalArgumentException();
        }
    }

    public static void price(int price) {
        if (price % 1000 != 0) {
            OutputView.errorMessage("금액이 올바르지 않습니다.");
            throw new IllegalArgumentException();
        }
    }
}
