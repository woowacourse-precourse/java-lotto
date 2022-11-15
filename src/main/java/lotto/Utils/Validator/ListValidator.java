package lotto.Utils.Validator;




import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListValidator {

    private static final String ERROR_MESSAGE="[ERROR]";

    public static void validateRange(String StringNumber) {
        int number = Integer.parseInt(StringNumber);
        if (!(number > 0 && number < 46)) {
            throw new IllegalArgumentException(ERROR_MESSAGE+" 입력값의 범위가 맞지 않습니다.");
        }
    }

    public static void Overlaped(List<Integer> List) {
        Set<Integer> numSet = new HashSet<>(List);

        if (numSet.size() != List.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE+" 중복되는 값이 있습니다.");
        }
    }



    public static void length(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE+" 당첨번호의 길이가 올바르지 않습니다.");
        }
    }


}
