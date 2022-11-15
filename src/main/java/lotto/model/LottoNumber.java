package lotto.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class LottoNumber {

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    private static final String NUMBER_PATTERN = "\\d+";
    private static final Map<Integer, LottoNumber> LottoNumbers = new HashMap<>();

    static {
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            LottoNumbers.put(i, new LottoNumber(i));
        }
    }

    private final int number;

    private LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    public static LottoNumber of(int number) {
        return Optional.ofNullable(LottoNumbers.get(number))
                .orElseThrow(() -> new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다."));
    }

    public static LottoNumber of(String lottoNumber) {
        validateNumber(lottoNumber);
        return of(Integer.parseInt(lottoNumber));
    }

    private static void validateNumber(String money) {
        if (!money.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }

    private void validate(int number) {
        if (!isValidNumber(number)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private boolean isValidNumber(int number) {
        return number >= MIN_LOTTO_NUMBER && number <= MAX_LOTTO_NUMBER;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
