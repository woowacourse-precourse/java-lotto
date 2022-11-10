package user;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoDraw {
    private static final String COMMA_ERROR = "쉼표로 구분된 6개 숫자를 입력해 주시기 바랍니다.";
    private static final String DUPLICATION_ERROR = "입력된 숫자에 중복이 있습니다.";

    private static LottoDraw lottoDraw;

    private LottoDraw() {
    }

    public static LottoDraw getInstance() {
        if (lottoDraw == null) {
            lottoDraw = new LottoDraw();
        }
        return lottoDraw;
    }

    public List<Integer> pickWinNumbers(String readline) {
        validateComma(readline);
        List<Integer> winNumbers = changeStringToInt(readline);
        validateDuplication(winNumbers);
        return winNumbers;
    }

    private List<Integer> changeStringToInt(String readline) {
        int[] changeInteger= Arrays.stream(readline.split(",")).mapToInt(Integer::parseInt).toArray();
        return Arrays.stream(changeInteger).boxed().collect(Collectors.toList());
    }

    private void validateComma(String readline) {
        if (readline.split(",").length != 6) {
            throw new IllegalArgumentException(COMMA_ERROR);
        }
    }

    private void validateDuplication(List<Integer> winNumbers) {
        if (duplicateNumbers(winNumbers)){
            throw new IllegalArgumentException(DUPLICATION_ERROR);
        }
    }

    private boolean duplicateNumbers(List<Integer> winNumbers) {
        return new HashSet<>(winNumbers).size() != winNumbers.size();
    }
}
