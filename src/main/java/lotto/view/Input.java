package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import lotto.domain.Money;

public class Input {
    private static final String ERROR_MESSAGE = "[ERROR]";

    public Money getMoney() {
        String money = Console.readLine().trim();
        isNumber(money);
        return new Money(Integer.parseInt(money));
    }

    public List<Integer> getWinningNumber() {
        Output.printWinningNumberInputMessage();
        String winningNumber = Console.readLine();
        String comma = ",";
        String[] splitNumber = winningNumber.split(comma);
        validateWinningNumber(splitNumber);

        return Arrays.asList(splitNumber).stream().map(String::trim).mapToInt(Integer::valueOf).boxed()
                .collect(Collectors.toList());
    }

    public Integer getBonusNumber() {
        // TODO: 중복 제거
        Output.printBonusNumberInputMessage();
        String bonusNumber = Console.readLine().trim();
        isNumber(bonusNumber);
        return Integer.valueOf(bonusNumber);
    }

    private void validateWinningNumber(String[] winningNumber) {
        if (Arrays.stream(winningNumber).distinct().count() != winningNumber.length) {
            throw new IllegalArgumentException("[error]");
        }
        if (winningNumber.length != 6) {
            throw new IllegalArgumentException("[error]");
        }
        for (String number : winningNumber) {
            number = number.trim();
            isNumber(number);
            if (!isRangeNumber(Integer.valueOf(number))) {
                throw new IllegalArgumentException("[error]");
            }
        }
    }

    private void isNumber(String number) {
        Pattern pattern = Pattern.compile("^[0-9]*$");
        if (!pattern.matcher(number).find()) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isRangeNumber(int number) {
        return number >= 1 && number <= 45;
    }
}
