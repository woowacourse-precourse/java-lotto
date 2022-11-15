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

    /**
     * 입력받은 금액을 사용자의 정보에 저장한다.
     *
     * @param inputMoney 입력받은 금액
     */
    public void setMoneyToUser(String inputMoney) {
        moneyValidate(inputMoney);
        user = new User(Integer.parseInt(inputMoney));
    }

    /**
     * 금액에 이상이 있으면 예외를 던진다.
     *
     * @param money 금액
     */
    public void moneyValidate(String money) {
        inputException.notDigitException(money);
        inputException.notThousandMoneys(Integer.parseInt(money));
    }

    /**
     * 유저의 정보에 입력받은 로또의 번호를 저장한다.
     *
     * @param inputNumbers 입력받은 로또의 번호
     */
    public void setNumbersToUser(String inputNumbers) {
        user.setNumbers(getValidateNumbers(inputNumbers)
                .stream()
                .sorted()
                .collect(Collectors.toList()));
    }

    /**
     * 로또의 번호의 번호에 이상이 있으면 예외를 던지고 없으면 로또의 번호를 가져온다.
     *
     * @param inputNumbers 입력받은 로또의 번호
     * @return 로또의 번호
     */
    public List<Integer> getValidateNumbers(String inputNumbers) {
        List<Integer> numbers;
        inputException.invalidNumbers(inputNumbers);
        numbers = toList(inputNumbers);
        inputException.numbersRangeException(numbers);
        inputException.duplicateNumberException(numbers);
        return numbers;
    }

    /**
     * 입력받은 로또의 번호를 리스트 형식으로 반환한다.
     *
     * @param inputNumbers 입력받은 로또의 번호
     * @return 리스트 형식의 로또의 번호
     */
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

    /**
     * 보너스 번호에 이상이 있으면 예외를 던진다.
     * @param bonusNumber   보너스 번호
     */
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
