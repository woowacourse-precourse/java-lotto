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
            validateSlice(slice, "로또 번호");
        }
        List<Integer> winningNumbers = inputSlices.stream().map(Integer::parseInt).collect(Collectors.toList());
        LottoValidator.validateOverlap(winningNumbers);
        LottoValidator.validateSize(winningNumbers);
        LottoValidator.validateRange(winningNumbers);

        winningNumberSet = new HashSet<>();
        winningNumberSet.addAll(winningNumbers);
    }

    private void validateSlice(String slice, String type) {
        for (int i = 0; i < slice.length(); i++) {
            if (!Character.isDigit(slice.charAt(i))) {
                throw new IllegalArgumentException("[ERROR] " + type + " 입력 형식이 잘못되었습니다.");
            }
        }
    }

    public void setBonusNumber(String input) {
        validateSlice(input, "보너스 번호");
        bonusNumber = Integer.parseInt(input);
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호 범위가 올바르지 않습니다.");
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
