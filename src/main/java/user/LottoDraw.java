package user;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoDraw {
    private static final String COMMA_ERROR = "쉼표로 구분된 6개 숫자를 입력해 주시기 바랍니다.";
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
        int[] a = Arrays.stream(readline.split(",")).mapToInt(Integer::parseInt).toArray();
        return Arrays.stream(a).boxed().collect(Collectors.toList());
    }

    private void validateComma(String readline) {
        if (readline.split(",").length != 6) {
            throw new IllegalArgumentException(COMMA_ERROR);
        }
    }
}
