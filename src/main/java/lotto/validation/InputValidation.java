package lotto.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputValidation {

    public void validatePrice(String price) {
        if (!Pattern.matches("^[1-9][0-9]*0{3}$", price)) {
            throw new IllegalArgumentException("로또 구입 금액은 1000으로 나누어 떨어지는 금액입니다.");
        }
    }

    public void validateWinningNumbers(String numbers) {
        if (!Pattern.matches("^[0-9]{1,2},[0-9]{1,2},[0-9]{1,2},[0-9]{1,2},[0-9]{1,2},[0-9]{1,2}$", numbers)) {
            throw new IllegalArgumentException("당첨 번호는 6개의 숫자와 5개의 구분자로 이루어져있습니다.");
        }

        List<Integer> temp = new ArrayList<>();
        List<Integer> winningNumbers = Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (Integer winningNumber : winningNumbers) {
            if (temp.contains(winningNumber)) {
                throw new IllegalArgumentException("당첨 번호는 중복될 수 없습니다.");
            }
            if (winningNumber == 0 || winningNumber > 45) {
                throw new IllegalArgumentException("");
            }
            temp.add(winningNumber);
        }
    }

    public void validateBonusNumber(String number, List<Integer> winningNumbers) {
        if (!Pattern.matches("^[0-9]{1,2}$", number)) {
            throw new IllegalArgumentException("보너스 번호는 한 자리 혹은 두 자리 숫자입니다.");
        }

        int bonusNumber = Integer.parseInt(number);
        if (bonusNumber == 0 || bonusNumber > 45) {
            throw new IllegalArgumentException("당첨 번호는 최대 45 입니다.");
        }

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
