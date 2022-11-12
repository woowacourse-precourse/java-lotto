package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import lotto.domain.Money;

public class Input {

    public Money getMoney() {
        Output.printMoneyInputMessage();
        String money = Console.readLine();
        return new Money(Integer.valueOf(money));
    }

    public List<Integer> getWinningNumber() {
        Output.printWinningNumberInputMessage();
        String winningNumber = Console.readLine();
        String comma = ",";
        String[] splitNumber = winningNumber.split(comma);
        validateWinningNumber(splitNumber);

        return Arrays.asList(splitNumber).stream().mapToInt(Integer::valueOf).boxed().collect(Collectors.toList());
    }

    public Integer getBonusNumber() {
        Output.printBonusNumberInputMessage();
        String bonusNumber = Console.readLine();
        if (!isNumber(bonusNumber)) {
            throw new IllegalArgumentException();
        }
        return Integer.valueOf(Console.readLine());
    }

    public void validateWinningNumber(String[] winningNumber) {
        if (winningNumber.length != 6) {
            throw new IllegalArgumentException("[error]");
        }
        for (String number : winningNumber) {
            if (!isNumber(number)) {
                throw new IllegalArgumentException("[error]");
            }
            if (!isRangeNumber(Integer.valueOf(number))) {
                throw new IllegalArgumentException("[error]");
            }
        }
    }

    public boolean isNumber(String number) {
        Pattern pattern = Pattern.compile("^[0-9]*$");
        return pattern.matcher(number.trim()).find();
    }

    public boolean isRangeNumber(int number) {
        return number >= 1 && number <= 45;
    }


}
