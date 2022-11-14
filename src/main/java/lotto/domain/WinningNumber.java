package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import lotto.dto.WinningNumberDto;
import lotto.utils.Utils;

public class WinningNumber {

    private static final String NUMBER_SEPARATOR = ",";
    private static final String WINNING_NUMBER_REGEX = "^[0-9]*,[0-9]*,[0-9]*,[0-9]*,[0-9]*,[0-9]*$";
    private static final String WRONG_WINNING_NUMBER_FORM = "올바르지 않은 당첨 번호 형식 입니다.";

    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningNumber(String winningNumber, String bonusNumber) {
        winningNumber = validateWinningNumber(winningNumber);
        List<Integer> parsedWinningNumber = parseWinningNumber(winningNumber);

        lotto = new Lotto(parsedWinningNumber);
        this.bonusNumber = new BonusNumber(bonusNumber, parsedWinningNumber);
    }

    private String validateWinningNumber(String winningNumber) {
        winningNumber = Utils.deleteAllString(winningNumber);
        if (!Pattern.matches(WINNING_NUMBER_REGEX, winningNumber)) {
            throw new IllegalArgumentException(WRONG_WINNING_NUMBER_FORM);
        }
        return winningNumber;
    }

    private List<Integer> parseWinningNumber(String winningNumber) {
        return Arrays.stream(winningNumber.split(NUMBER_SEPARATOR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public WinningNumberDto toDto() {
        return new WinningNumberDto(lotto, bonusNumber);
    }
}
