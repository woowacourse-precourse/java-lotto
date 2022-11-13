package lotto;

public class LottoValidator {
    public static boolean checkLottoRange(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45사이의 숫자여야합니다.");
        }
        return true;
    }
}
