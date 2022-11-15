package lotto.domain;

import java.util.List;

public class Valid {
    public static final int lottoPrice = 1000;
    public static final int lottoSize = 6;
    public static final int startLottoNum = 1;
    public static final int endLottoNum = 45;

    public void isCorrectSize(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != lottoSize) {
            throw new IllegalArgumentException("번호는 " + lottoSize + "개 여야 합니다.");
        }
    }

    public void isCorrectRange(List<Integer> numbers) throws IllegalArgumentException {
        if (!numbers.stream()
                .allMatch(number -> (number >= startLottoNum && number <= endLottoNum))) {
            throw new IllegalArgumentException(startLottoNum + "부터 " + endLottoNum + " 사이의 숫자여야 합니다.");
        }
    }

    public void isNoDuplicate(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("중복되는 숫자가 없어야 합니다.");
        }
    }

    public void isNumeric(String amount) throws IllegalArgumentException {
        if (!amount.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    public void isCorrectPrice(String amount) throws IllegalArgumentException {
        if (Integer.parseInt(amount) % lottoPrice != 0) {
            throw new IllegalArgumentException(lottoPrice + "원 단위로 입력해주세요.");
        }
    }
}
