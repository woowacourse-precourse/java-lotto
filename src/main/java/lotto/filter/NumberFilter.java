package lotto.filter;

public class NumberFilter implements Filter {
    @Override
    public void doFilter(String number) {
        if (number == null || number.equals("")) {
            throw new IllegalArgumentException("하나 이상의 숫자를 입력해 주세요.");
        }

        for (char i : number.toCharArray()) {
            if (!Character.isDigit(i)) {
                throw new IllegalArgumentException("입력한 문자가 숫자가 아닙니다.");
            }
        }
    }
}
