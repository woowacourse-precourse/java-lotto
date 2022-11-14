package lotto.filter;

public class BonusSizeFilter implements Filter {

    private static final int VALID_LENGTH = 1;

    @Override
    public void doFilter(String number) {

        if (number.length() != VALID_LENGTH) {
            throw new IllegalArgumentException("보너스 번호는 1개만 입력되어야 합니다");
        }
    }
}
