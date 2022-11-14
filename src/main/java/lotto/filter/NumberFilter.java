package lotto.filter;

public class NumberFilter implements Filter {
    @Override
    public void doFilter(String number) {

        if (number.equals("")) {
            throw new IllegalArgumentException("빈 입력은 허용되지 않습니다.");
        }

        for (char i : number.toCharArray()) {
            if (!Character.isDigit(i)) {
                throw new IllegalArgumentException("입력한 문자가 숫자가 아닙니다.");
            }
        }
    }
}
