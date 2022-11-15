package lotto.controller.dto;

import lotto.controller.validator.BonusNumberValidator;
import lotto.controller.validator.WinningNumberValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbersDto implements Dto{

    private List<Integer> winningNumber;
    private int bonusNumber;

    public WinningNumbersDto(String winningNumber, String bonusNumber) {
        validateInput(winningNumber, WinningNumberValidator.values());
        validateInput(bonusNumber, BonusNumberValidator.values());

        this.winningNumber = separateStringWithComma(winningNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);

        validate(this.winningNumber, this.bonusNumber);
    }

    private void validate(List<Integer> winningNumber, int bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호는 중복될 수 없습니다.");
        }
    }

    private List<Integer> separateStringWithComma(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
