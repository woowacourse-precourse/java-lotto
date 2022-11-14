package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class InputView {
    private static final int LOTTO_SIZE = 6;
    private static final int START_VALUE = 1;
    private static final int END_VALUE = 45;

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = convertInteger(Console.readLine());

        isValidationForMoney(money);

        return money;
    }

    public List<Integer> inputWinningLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningLottoNumbers = convertIntegerList(Console.readLine());

        isCorrectLottoSize(winningLottoNumbers);
        isCorrectLottoNumber(winningLottoNumbers);
        isUnique(winningLottoNumbers);

        return winningLottoNumbers;
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = convertInteger(Console.readLine());
        isCorrectBonusNumber(bonusNumber);
        return bonusNumber;
    }

    private void isCorrectBonusNumber(int bonusNumber) {
        if (bonusNumber < START_VALUE || bonusNumber > END_VALUE) {
            throw new IllegalArgumentException(ErrorMessage.NOT_LOTTO_NUMBER.getMessage());
        }
    }

    private void isCorrectLottoNumber(List<Integer> winningLottoNumbers) {
        Long incorrectNumberCount = winningLottoNumbers.stream()
                .filter(n -> (n < START_VALUE || n > END_VALUE))
                .count();

        if (incorrectNumberCount > 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_LOTTO_NUMBER.getMessage());
        }
    }

    private void isUnique(List<Integer> winningLottoNumbers) {
        for (int i = 0; i < 6; i++) {
            if (!(winningLottoNumbers.indexOf(winningLottoNumbers.get(i)) == i)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER.getMessage());
            }
        }
    }

    private void isCorrectLottoSize(List<Integer> winningLottoNumbers) {
        if (winningLottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NOT_LOTTO_SIZE.getMessage());
        }
    }

    private List<Integer> convertIntegerList(String numbers) {
        try {
            return Arrays.stream(numbers.split(","))
                    .mapToInt(number -> Integer.parseInt(number))
                    .boxed()
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
        }
    }

    private void isValidationForMoney(int money) {
        if (isLessThan1000(money)) {
            throw new IllegalArgumentException(ErrorMessage.SMALL_NUMBER.getMessage());
        }

        if (!(isDivideBy1000(money))) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVIDED.getMessage());
        }
    }

    private int convertInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
        }
    }

    private boolean isLessThan1000(int money) {
        return money < 1000;
    }

    private boolean isDivideBy1000(int money) {
        if (money % 1000 == 0) {
            return true;
        }
        return false;
    }

}