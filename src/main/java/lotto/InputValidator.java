package lotto;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputValidator {
    public void validateLotto(List<Integer> lotto) {
        validateLottoSize(lotto);
        validateDuplicatedLotto(lotto);
        for (Integer number : lotto) {
            validateLottoNumber(number);
        }
    }

    public void validateOnlyNumbers(String inputString) {
        String regexOnlyNumbers = "^[0-9]*$";
        Matcher matcherOnlyNumbers = Pattern.compile(regexOnlyNumbers).matcher(inputString);
        if (!matcherOnlyNumbers.matches()){
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
    }

    public void validateBonusNumber(int bonusNumber) {
        validateLottoNumber(bonusNumber);
    }

    public void validatePurchaseAmount(int cash) {
        if (cash != cash / 1000 * 1000 || cash < 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    private void validateLottoNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개입니다.");
        }
    }

    private void validateDuplicatedLotto(List<Integer> numbers) {
        if (!numbers.stream().distinct().collect(Collectors.toList()).equals(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복일 수 없습니다.");
        }
    }


}
