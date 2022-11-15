package lotto.reward;

import lotto.utils.MoneyFalseException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//숫자 클래스 재정의
public class Numbers implements Comparable<Numbers> {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;

    private static final Pattern CORRECT_NUMBER_PATTERN = Pattern.compile("^[0-9]*$");
    private final int number;

    private final static Map<Integer, Numbers> lottoNumbers = new HashMap<>();

    private Numbers(int number) {
        this.number = number;
    }

    static {
        for (int i = START_NUMBER; i <= END_NUMBER; i++) {
            lottoNumbers.put(i, new Numbers(i));
        }
    }

    //1~45의 자동 발행 숫자 검증
    public static Numbers of(int number) {
        Numbers lottoNumber = lottoNumbers.get(number);
        if (!lottoNumbers.containsKey(number)) {
            throw new IllegalArgumentException("not find key");
        }
        return lottoNumber;
    }

    //입력 받은 숫자 문자인지 검증 후 int형 변환 후 반환
    public static Numbers of(String input) {
        Matcher matcher = CORRECT_NUMBER_PATTERN.matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException(MoneyFalseException.catchException());
        }
        return of(String.valueOf(Integer.parseInt(input)));
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numbers that = (Numbers) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(Numbers o) {
        return this.number - o.number;
    }
}
