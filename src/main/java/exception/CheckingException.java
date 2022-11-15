package exception;

public class CheckingException {
    // 올바른 숫자가 입력됐는지 점검
    public void isNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 금액은 숫자만 입력해야합니다.");
            throw new IllegalArgumentException();
        }
    }
}
