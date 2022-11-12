package lotto.view;

import lotto.validator.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoView {
    private final Validator validator;

    public LottoView(Validator validator) {
        this.validator = validator;
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public int inputMoney() {
        // 입력값이 정수형태가 아닌경우 NumberFormatException
        int money = Integer.parseInt(readLine());
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
