package lotto.filter;

public class CashUnitFilter implements Filter {

    private static final int CASH_UNIT = 1000;

    @Override
    public void doFilter(String cash) {
        int numberVerifiedCash = Integer.parseInt(cash);

        if (numberVerifiedCash == 0 || numberVerifiedCash % CASH_UNIT != 0) {
            throw new IllegalArgumentException("입력한 숫자가 1,000원 단위가 아닙니다");
        }
    }
}
