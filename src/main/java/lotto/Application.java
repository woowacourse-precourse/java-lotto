package lotto;

import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            LottoService lottoService = new LottoServiceImpl();
            lottoService.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
