package lotto;

import static lotto.util.Printer.printErrorMessage;

import lotto.service.LottoService;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            LottoService lottoService = new LottoService();
            lottoService.play();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
        }
    }
}
