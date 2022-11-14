package lotto.dto;

import lotto.util.StringUtils;

import java.util.List;
import java.util.regex.Pattern;

public class BonusNumberDto {
    private static final String NUMBER_PATTERN = "^[1-9]{1}$|^[1-3]{1}[0-9]{1}$|^4{1}[0-5]{1}$";    // 1 ~ 45
    private static final String NUMBER_FORM_EXCEPTION_MESSAGE = "보너스 번호는 1 ~ 45 사이 숫자여야 합니다.";
    private static final String BLANK_INPUT_EXCEPTION_MESSAGE = "Null 또는 Empty 를 입력할 수 없습니다.";
    private static final String DUPLICATE_INPUT_EXCEPTION_MESSAGE = "보너스 번호는 당첨 번호와 다른 값이어야 합니다.";

    private int bonusNumber;
    private WinningNumbersDto winningNumbersDto;

    public BonusNumberDto(String bonusNumber, WinningNumbersDto winningNumbersDto) {
        this(parseBonusNumber(bonusNumber), winningNumbersDto);
    }

    public BonusNumberDto(int bonusNumber, WinningNumbersDto winningNumbersDto) {
        validateDuplicate(bonusNumber, winningNumbersDto);
        this.bonusNumber = bonusNumber;
        this.winningNumbersDto = winningNumbersDto;
    }

    private void validateDuplicate(int bonusNumber, WinningNumbersDto winningNumbersDto) {
        List<Integer> winningNumbers = winningNumbersDto.getWinningNumbers();

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_INPUT_EXCEPTION_MESSAGE);
        }
    }

    private static void validate(final String bonusNumber) {
        validateBlank(bonusNumber);
        validateNumber(bonusNumber);
    }

    private static void validateNumber(final String bonusNumber) {
        if (!Pattern.matches(NUMBER_PATTERN, bonusNumber)) {
            throw new IllegalArgumentException(NUMBER_FORM_EXCEPTION_MESSAGE);
        }
    }

    private static void validateBlank(final String bonusNumber) {
        if (StringUtils.isBlank(bonusNumber)) {
            throw new IllegalArgumentException(BLANK_INPUT_EXCEPTION_MESSAGE);
        }
    }

    private static int parseBonusNumber(final String bonusNumber) {
        validate(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
