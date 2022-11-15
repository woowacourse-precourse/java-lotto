package lotto;

import lotto.service.LottoService;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = LottoService.getInstance();

        try {
            lottoService.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
