package lotto.service;

import lotto.domain.User;
import lotto.exception.InputException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private static final int LOTTERY_PRICE = 1000;
    User user;
    InputException inputException = new InputException();

    public void setMoneyToUser(String inputMoney) {
        user = new User(inputMoneyToInteger(inputMoney));
    }

    public int inputMoneyToInteger(String inputMoney) {
        inputException.notDigitException(inputMoney);
        inputException.notThousandMoneys(Integer.parseInt(inputMoney));
        return Integer.parseInt(inputMoney);
    }

    public void setNumbersToUser(String inputNumbers) {
        user.setNumbers(inputNumbersToList(inputNumbers)
                .stream()
                .sorted()
                .collect(Collectors.toList()));
    }

    public List<Integer> inputNumbersToList(String inputNumbers) {
        List<Integer> numbers = new ArrayList<>(Collections.emptyList());
        // 쉼표 사이에 공백이 있으면 예외처리
        // 숫자나 쉼표가 아니면 예외처라
        numbers = toList(inputNumbers);
        return numbers;
    }

    public List<Integer> toList(String inputNumbers) {
        List<Integer> numbers;
        String[] stringNumbers = inputNumbers.replace(" ", "").split(",");
        numbers = Arrays.stream(stringNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return numbers;
    }

    public void setBonusNumber(String inputBonusNumber) {
        bonusNumberValidate(inputBonusNumber);
        user.setBonusNumber(Integer.parseInt(inputBonusNumber));
    }

    public int getLottoQuantity() {
        return user.getMoney() / LOTTERY_PRICE;
    }


    public User getUser() {
        return user;
    }

    public void bonusNumberValidate(String bonusNumber) {
        inputException.notDigitException(bonusNumber);
        inputException.numbersRangeException(List.of(Integer.parseInt(bonusNumber)));
        inputException.duplicateBonusNumberException(getUser().getNumbers(), Integer.parseInt(bonusNumber));
    }
}
