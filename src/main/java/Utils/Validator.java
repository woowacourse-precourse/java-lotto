package Utils;

import java.util.HashSet;
import java.util.List;

public class Validator {

    public void sizeValidator(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void checkNumberRange(int n) {
        if (n < 1 || n > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public void checkDuplication(List<Integer> lottoNumbers) {
        HashSet<Integer> hashSet = new HashSet<>(lottoNumbers);

        if (hashSet.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력할 수 없습니다.");
        }
    }

    public void checkIfTheInputIsInteger(String digit) {
        if (!digit.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
    }

    public void validatePayment(String payment) {

        checkIfTheInputIsInteger(payment);

        if (Integer.parseInt(payment) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 떨어지는 숫자를 입력해주세요.");
        }
    }
}
