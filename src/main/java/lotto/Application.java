package lotto;

import lotto.service.LottoApplicationService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final LottoApplicationService lottoApplicationService
                = new LottoApplicationService();

        lottoApplicationService.inputMoney();
        lottoApplicationService.createLottos();
        lottoApplicationService.createWinningLottoNumbers();
    }
}
