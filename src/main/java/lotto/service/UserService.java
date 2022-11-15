package lotto.service;

import lotto.domain.User;
import lotto.exception.InputException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private static final int LOTTERY_PRICE = 1000;
    User user;
    InputException inputException = new InputException();

    public void setMoneyToUser(String inputMoney) {
        moneyValidate(inputMoney);
        user = new User(Integer.parseInt(inputMoney));
    }

    public void moneyValidate(String money) {
        inputException.notDigitException(money);
        inputException.notThousandMoneys(Integer.parseInt(money));
    }

    public void setNumbersToUser(String inputNumbers) {
        user.setNumbers(setNumbers(inputNumbers)
                .stream()
                .sorted()
                .collect(Collectors.toList()));
    }

    public List<Integer> setNumbers(String inputNumbers) {
        List<Integer> numbers;
        inputException.invalidNumbers(inputNumbers);
        numbers = toList(inputNumbers);
        inputException.numbersRangeException(numbers);
        inputException.duplicateNumberException(numbers);
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

    public void bonusNumberValidate(String bonusNumber) {
        inputException.notDigitException(bonusNumber);
        inputException.numbersRangeException(List.of(Integer.parseInt(bonusNumber)));
        inputException.duplicateBonusNumberException(getUser().getNumbers(), Integer.parseInt(bonusNumber));
    }

    public User getUser() {
        return user;
    }

    public int getLottoQuantity() {
        return user.getMoney() / LOTTERY_PRICE;
    }
}
