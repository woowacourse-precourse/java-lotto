package lotto.filter;

import lotto.util.DigitUtil;

public class NumberWithDotFilter implements Filter {

    private static final String SPLITTER = ",";
    private static final int VALID_SIZE = 6;

    @Override
    public void doFilter(String numberWithDot) {
        String[] numbers = numberWithDot.split(SPLITTER);

        if (numbers.length != VALID_SIZE) {
            throw new IllegalArgumentException("입력한 숫자의 형식이 잘못되었거나 갯수가 다릅니다");
        }

        for (String i : numbers) {
            if (i.equals("") || !DigitUtil.isDigit(i)) {
                throw new IllegalArgumentException("입력한 문자가 숫자가 아닙니다.");
            }
        }

    }
}
