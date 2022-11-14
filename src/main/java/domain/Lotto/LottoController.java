package domain.Lotto;

import java.util.regex.Pattern;

public class LottoController {
    private static final String FORMAT = "^[0-9]*,[0-9]*,[0-9]*,[0-9]*,[0-9]*,[0-9]*$";
    private final LottoService lottoService = new LottoService();

    public Lotto createWinningNumber(String winningNumber) {
        isNumber(winningNumber);
        return lottoService.createWinningNumber(winningNumber);
    }

    public void isNumber(String winningNumber) {
        if (!Pattern.matches(FORMAT, winningNumber)) {
            throw new IllegalArgumentException("당첨 번호는 쉼표로 구분된 6개의 숫자여야 합니다.");
        }
    }
}
