package lotto;

public class LottoNumberValidator {

    public static void isRightNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("로또 번호는 1에서 45사이의 수여야 합니다.");
        }
    }
}
