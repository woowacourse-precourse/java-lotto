package lotto.service;

import lotto.domain.User;
import lotto.exception.InputException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class InputService {
    User user;

    public int inputMoneyToInteger(String inputMoney) {
        InputException inputException = new InputException();
        inputException.notDigitException(inputMoney);
        inputException.notThousandMoneys(Integer.parseInt(inputMoney));
        return Integer.parseInt(inputMoney);
    }

    public List<Integer> inputNumbersToList(String inputNumbers) {
        List<Integer> numbers = new ArrayList<>(Collections.emptyList());
        numbers = toList(inputNumbers);
        return numbers;
    }

    private List<Integer> toList(String inputNumbers) {
        List<Integer> numbers = new ArrayList<>(Collections.emptyList());

        StringTokenizer st = new StringTokenizer(inputNumbers, ",");
        while (st.hasMoreTokens()) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }
        return numbers;
    }

    public void setMoneyToUser(String inputMoney) {
        user = new User(inputMoneyToInteger(inputMoney));
    }

    public void setNumbersToUser(String inputNumbers) {
        user.setNumbers(inputNumbersToList(inputNumbers));
    }

    public User getUser() {
        return user;
    }
}
