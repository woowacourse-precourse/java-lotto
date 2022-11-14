package lotto.dto;

import lotto.system.validator.ConvertingToWinningInfoValidator;
import lotto.vo.WinningInfo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningInfoDto {
    private String winningNumbers;
    private String bonus;

    public WinningInfoDto(String winningNumbers, String bonus) {
        this.winningNumbers = winningNumbers;
        this.bonus = bonus;
    }

    public WinningInfo toWinningInfo() {
        ConvertingToWinningInfoValidator.validate(this);

        List<Integer> winningNumbers = convertWinningNumberLettersToNumbers();
        int bonus = convertBonusToNumber();

        return new WinningInfo(winningNumbers, bonus);
    }

    private int convertBonusToNumber() {
        return Integer.parseInt(bonus);
    }

    private List<Integer> convertWinningNumberLettersToNumbers() {
        return Arrays.stream(winningNumbers
                        .replace(" ", "")
                        .split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public String getWinningNumbers() {
        return winningNumbers;
    }

    public String getBonus() {
        return bonus;
    }
}
