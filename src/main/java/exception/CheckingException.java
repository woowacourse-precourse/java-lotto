package exception;

import java.util.List;

public class CheckingException {
    public CheckingException(String amount) {
        isNumber(amount);
    }

    public CheckingException(List<Integer> numbers) {
        isRange(numbers);
    }

    // 올바른 숫자가 입력됐는지 점검
    public void isNumber(String amount) {
        try {
            Integer.parseInt(amount);
        } catch (Exception e) {
            throw new NumberFormatException("[ERROR] 금액은 숫자만 입력해야합니다.");
        }
    }

    public void isRange(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > 45 || numbers.get(i) < 1) {
                throw new NumberFormatException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }
}
