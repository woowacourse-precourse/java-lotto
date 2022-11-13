package lotto.service;

import lotto.domain.User;
import lotto.exception.InputException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InputService {
    User user;

    public void setMoneyToUser(String inputMoney) {
        user = new User(inputMoneyToInteger(inputMoney));
    }

    public int inputMoneyToInteger(String inputMoney) {
        InputException inputException = new InputException();
        inputException.notDigitException(inputMoney);
        inputException.notThousandMoneys(Integer.parseInt(inputMoney));
        return Integer.parseInt(inputMoney);
    }

    public void setNumbersToUser(String inputNumbers) {
        user.setNumbers(inputNumbersToList(inputNumbers));
    }

    public List<Integer> inputNumbersToList(String inputNumbers) {
        List<Integer> numbers = new ArrayList<>(Collections.emptyList());
        numbers = toList(inputNumbers);
        return numbers;
    }

    public List<Integer> toList(String inputNumbers) {
        List<Integer> numbers = new ArrayList<>(Collections.emptyList());
        numbers = Arrays.stream(
                        inputNumbers.replace(" ", "")
                                .split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return numbers;
    }

    public User getUser() {
        return user;
    }
}
