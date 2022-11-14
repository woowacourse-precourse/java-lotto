package lotto.filter;

import java.util.Arrays;

public class LottoDuplicationFilter implements Filter {

    private static final String SPLITTER = ",";
    private static final int ALLOW_MAX_SAME_COUNT = 2;

    @Override
    public void doFilter(String number) {
        String[] numbers = number.split(SPLITTER);

        for (String i : numbers) {
            long sameCount = Arrays.stream(numbers)
                    .filter(j -> j.equals(i))
                    .count();

            if (sameCount >= ALLOW_MAX_SAME_COUNT) {
                throw new IllegalArgumentException("중복되는 숫자가 존재합니다");
            }
        }
    }
}
