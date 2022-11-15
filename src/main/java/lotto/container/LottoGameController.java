package lotto.container;

import lotto.service.*;

public class LottoGameController {
    private RelativeLottoService relativeLottoService = new RelativeLottoService();
    private RelativeResultService relativeResultService;

    public void gameStart() {
        relativeLottoService.relativeLottoNumber();

        relativeResultService = new RelativeResultService(
                relativeLottoService.getMyLottoNumbers(),
                relativeLottoService.getWinningNumbers(),
                relativeLottoService.getBonusNumber(),
                relativeLottoService.getMoney()
        );

        relativeResultService.relativeResult();
    }

}
