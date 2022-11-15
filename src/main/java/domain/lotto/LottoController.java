package domain.Lotto;

import java.util.regex.Pattern;

public class LottoController {
    private static final String FORMAT = "^\\d*,\\d*,\\d*,\\d*,\\d*,\\d*$";
    private final LottoService lottoService = new LottoService();

    public void validateFormat(String inputNumber) {
        if (!Pattern.matches(FORMAT, inputNumber)) {
            throw new IllegalArgumentException("당첨 번호는 공백 없이 쉼표로 구분된 6개의 숫자여야 합니다.");
        }
    }

    public Lotto createLotto(String inputNumber) {
        validateFormat(inputNumber);
        return lottoService.createLotto(inputNumber);
    }
}
