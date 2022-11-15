package lotto.filter;

public class LottoRangeFilter implements Filter {

    private static final String SPLITTER = ",";
    private static final int ALLOW_MIN_RANGE = 1;
    private static final int ALLOW_MAX_RANGE = 45;

    @Override
    public void doFilter(String number) {
        String[] numbers = number.split(SPLITTER);

        for (String i : numbers) {
            int rangeCheckNumber = Integer.parseInt(i);

            if (rangeCheckNumber < ALLOW_MIN_RANGE || rangeCheckNumber > ALLOW_MAX_RANGE) {
                throw new IllegalArgumentException("유효한 범위의 복권 번호가 아닙니다.");
            }
        }


    }
}
