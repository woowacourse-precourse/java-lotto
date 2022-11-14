package lotto.ui;

public class Exception {
    public static void validateInputLottoNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            System.exit(0);
        }
    }
}
