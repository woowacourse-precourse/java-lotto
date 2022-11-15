package lotto;

import java.util.List;

public class LottoController {

    private LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public int getOrderQuantity(int orderPrice) {
        return lottoService.getOrderQuantity(orderPrice);
    }

    public List<Lotto> createLottos(int orderQuantity) {
        return lottoService.createLottos(orderQuantity);
    }

    public WinningLotto createWinningLotto(List<Integer> lottoNumbers, int bonusNumber) {
        return lottoService.createWinningLotto(lottoNumbers, bonusNumber);
    }

    public List<LottoResult> getLottoResults(WinningLotto winningLotto, List<Lotto> userLottos) {
        return lottoService.getLottoResults(winningLotto, userLottos);
    }

    public float calculateRateOfReturn(List<LottoResult> lottoResults) {
        return lottoService.calculateRateOfReturn(lottoResults);
    }

}
