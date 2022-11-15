package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoIssuer;
import lotto.service.LottoService;
import lotto.util.ValidUtil;


public class Application {


    public static void main(String[] args) {
        LottoIssuer lottoIssuer = new LottoIssuer();
        LottoService lottoService = new LottoService(lottoIssuer);
        ValidUtil validUtil = new ValidUtil();
        LottoController lottoController = new LottoController(lottoService, validUtil);
        // TODO: 프로그램 구현
        lottoController.start();
    }
}
