package lotto.util;

public class InputLottoValidator {

    public static void validateInputLotto(String inputLotto) {
        if (inputLotto.contains(" ")) throw new IllegalArgumentException("입력값에 공백이 없어야 합니다.");
        if (inputLotto.contains(",,")) throw new IllegalArgumentException("숫자가 ,로 구분되어 입력되어야 합니다.");
    }
}