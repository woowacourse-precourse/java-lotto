package lotto.reward;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Number implements Comparable<Number> {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;

    private static final Pattern CORRECT_NUMBER_PATTERN = Pattern.compile("^[0-9]*$");
    private static final Map<Integer, Number> lottoNumbers = new HashMap<>();
    private final int number;

    static {
        for (int i = START_NUMBER; i <= END_NUMBER; i++) {
            lottoNumbers.put(i, new Number(i));
        }
    }

    private Number(int number) {
        this.number = number;
    }

    public static Number of(int number) {
        Number num = lottoNumbers.get(number);
        if (!lottoNumbers.containsKey(number)) {
            throw new IllegalArgumentException("key error");
        }
        return num;
    }

    public static Number of(String input) {
        Matcher matcher = CORRECT_NUMBER_PATTERN.matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException("올바른 숫자 입력이 아닙니다.");
        }
        return of(String.valueOf(Integer.parseInt(input)));
    }

    public int getNumber() {
        return number;
    }


    /*
    public Lotto(RandomNumbers randomNumbers) {
        numbers = new ArrayList<>(randomNumbers.createRandomNumbers());
    }

    public List<Integer> getLottoSixNumbers() {
        return numbers;
    }

    public Long matchCountNumbers(Lotto winningNumber) {
        return numbers.stream()
                .filter(winningNumber.getLottoSixNumbers()::contains)
                .count();
    }
    */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number that = (Number) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(Number o) {
        return this.number - o.number;
    }
}
