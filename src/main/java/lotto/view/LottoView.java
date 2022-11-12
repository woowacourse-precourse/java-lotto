package lotto.view;

import lotto.constant.ErrorMessage;
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

    public int inputMoney() {
        int money = 0;
        try {
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
}
