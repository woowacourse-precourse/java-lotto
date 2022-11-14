package lotto.domain;

import lotto.setting.Setting;

public class WinningNumber {

    private Lotto lotto;

    // 당첨 번호 생성 기능
    public void inputWinningNumber(String input) {
        validateInput(input);
    }

    // 올바른 당첨 번호 입력값인지 검증하는 기능
    private void validateInput(String input) {
        haveFiveComma(input);
    }

    // 쉼표(,)가 5개인지 확인하는 기능
    private void haveFiveComma(String input) {
        int commaCount = 0;
        for (int index = 0; index < input.length(); index++) {
            if (isComma(input.charAt(index))) {
                commaCount += 1;
            }
        }
        if (commaCount != Setting.INPUT_WINNING_NUMBER_COMMA_COUNT) {
            throw new IllegalArgumentException("[ERROR] 6자리 수를 5개의 쉼표(,)로 구분해야 합니다.");
        }
    }

    // 쉼표(,)인지 확인하는 기능
    private boolean isComma(char digit) {
        return digit == ',';
    }
}
