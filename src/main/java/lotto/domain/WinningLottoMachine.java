package lotto.domain;

import java.util.List;

public class WinningLottoMachine {

    public List<Integer> giveWinningLottoNumber(String input) {
        return List.of(1);
    }

    public int giveWinningLottoBonusNumber(String input) {
        validateBlank(input);
        int bonusNumber = validateNumeric(input);
        return bonusNumber;
    }

    private int validateNumeric(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("수가 아닌 입력이 있습니다.");
        }
        return number;
    }

    private void validateBlank(String input) {
        if (input.length() == 0) {
            throw new IllegalArgumentException("빈 문자열이 입력되었습니다.");
        }
    }
}

