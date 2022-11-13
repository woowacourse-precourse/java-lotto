package controller;

import domain.Lotto;
import service.LottoService;

import java.util.regex.Pattern;

public class LottoController {
    private static final String FORMAT = "^[0-9],[0-9],[0-9],[0-9],[0-9],[0-9]$";
    private final LottoService lottoService = new LottoService();

    public Lotto createWinningNumber(String winningNumber) {
        if (!isNumber(winningNumber))
            throw new IllegalArgumentException("당첨 번호는 쉼표로 구분된 숫자여야 합니다.");
        return lottoService.createWinningNumber(winningNumber);
    }

    public boolean isNumber(String winningNumber) {
        return Pattern.matches(FORMAT, winningNumber);
    }
}
