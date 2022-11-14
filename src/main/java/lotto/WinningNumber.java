package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {

    private final HashSet<Integer> winningNumberSet;
    private int bonusNumber;
    private static HashMap<Integer, Grade> gradeMap = new HashMap<>() {{
        put(3, Grade.FIFTH); put(4, Grade.FORTH); put(5, Grade.THIRD);
        put(6, Grade.FIRST); put(7, Grade.SECOND);
    }};

    public WinningNumber(String input) {
        List<String> inputSlices = Arrays.stream(input.split(",")).map(String::trim).collect(Collectors.toList());
        for (String slice : inputSlices) {
            validateSlice(slice);
        }
        List<Integer> winningNumbers = inputSlices.stream().map(Integer::parseInt).collect(Collectors.toList());
        LottoValidator.validateOverlap(winningNumbers);
        LottoValidator.validateSize(winningNumbers);
        LottoValidator.validateRange(winningNumbers);

        winningNumberSet = new HashSet<>();
        winningNumberSet.addAll(winningNumbers);
    }

    private void validateSlice(String slice) {
        for (int i = 0; i < slice.length(); i++) {
            if (!Character.isDigit(slice.charAt(i))) {
                throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_FORMAT_ERROR);
            }
        }
    }

    public void setBonusNumber(String input) {
        validateSlice(input);
        bonusNumber = Integer.parseInt(input);
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_RANGE_ERROR);
        }
        if (winningNumberSet.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_DUPLICATE_ERROR);
        }
    }

    public Grade judge(Lotto lotto) {
        int matchCount = 0;
        for (int lottoNumber : lotto.getNumbers()) {
            if (winningNumberSet.contains(lottoNumber)) {
                matchCount += 1;
            }
        }
        if (matchCount == 5 && lotto.getNumbers().contains(bonusNumber)) {
            matchCount += 2;
        }
        if (gradeMap.containsKey(matchCount)) {
            return gradeMap.get(matchCount);
        }
        return Grade.NOTHING;
    }
}
