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

    public LottoStats getLottoStats(WinningLotto winningLotto, List<Lotto> userLottos) {
        List<LottoResult> lottoResults = lottoService.getLottoResults(winningLotto, userLottos);
        LottoStats lottoStats = lottoService.getLottoStats(lottoResults);

        return lottoStats;
    }
}
