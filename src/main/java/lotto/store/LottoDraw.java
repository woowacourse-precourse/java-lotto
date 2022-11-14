package lotto.store;

import lotto.ValidCheck;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoDraw {
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
        ValidCheck.isComma(readline);
        ValidCheck.isNumeric(readline.split(","));
        List<Integer> winNumbers = changeStringToInt(readline);
        ValidCheck.isDuplication(winNumbers);
        ValidCheck.isRange(winNumbers);
        return winNumbers;
    }

    public int pickBonusNumber(String readline) {
        ValidCheck.isNumeric(new String[]{readline});
        int bonusNumber = Integer.parseInt(readline);
        ValidCheck.isRange(bonusNumber);
        return bonusNumber;
    }

    private List<Integer> changeStringToInt(String readline) {
        int[] changeInteger = Arrays.stream(readline.split(",")).mapToInt(Integer::parseInt).toArray();
        return Arrays.stream(changeInteger).boxed().collect(Collectors.toList());
    }

}
