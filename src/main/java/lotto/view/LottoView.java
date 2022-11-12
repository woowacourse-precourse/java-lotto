package lotto.view;

import lotto.validator.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.constant.ErrorMessage.*;

public class LottoView {
    private final Validator validator;

    public LottoView(Validator validator) {
        this.validator = validator;
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printBlankLine() {
        System.out.println();
    }

    public void printExceptionMessage(Exception exception) {
        System.out.println(ERROR + exception.getMessage());
    }

    public int inputMoney() {
        int money = 0;
        try {   // TODO validate 내부로 넣을지 고민
            money = Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MONEY);
        }
        validator.validateMoney(money);
        return money;
    }

    public List<Integer> inputWinningNumbers() {
        String input = readLine();
        return stringToList(input);
    }

    public List<Integer> stringToList(String input) {
        List<String> numbers = Arrays.asList(input.split(","));
        return numbers.stream().map(number -> Integer.parseInt(number)).collect(Collectors.toList());
    }

    public int inputBonusNumber(List<Integer> winningNumbers) {
        String input = readLine();
        validator.validateBonusNumber(winningNumbers, input);
        return Integer.parseInt(input);
    }
}
