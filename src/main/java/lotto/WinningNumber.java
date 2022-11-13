package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {

    private final List<Integer> winningNumbers;
    private int bonusNumber;

    public WinningNumber(String input) {
        List<String> inputSlices = Arrays.stream(input.split(",")).map(String::trim).collect(Collectors.toList());
        for (String slice : inputSlices) {
            validateSlice(slice, "로또 번호");
        }
        winningNumbers = inputSlices.stream().map(Integer::parseInt).collect(Collectors.toList());
        LottoValidator.validateOverlap(winningNumbers);
        LottoValidator.validateSize(winningNumbers);
        LottoValidator.validateRange(winningNumbers);
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
}
