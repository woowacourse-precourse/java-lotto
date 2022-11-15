package lotto;

import lotto.service.LottoService;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        // TODO: 프로그램 구현
        LottoService service = new LottoService();
        try {
            service.start();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
