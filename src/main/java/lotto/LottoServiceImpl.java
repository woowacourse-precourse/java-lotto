package lotto;

import java.util.List;

public class LottoServiceImpl implements LottoService {
    private final int LOTTO_PRICE = 1000;

    private LottoFactory lottoFactory;
    private LottoAccountant lottoAccountant;

    public LottoServiceImpl(LottoFactory lottoFactory, LottoAccountant lottoAccountant) {
        this.lottoFactory = lottoFactory;
        this.lottoAccountant = lottoAccountant;
    }

    @Override
    public int getOrderQuantity(int orderPrice) {
        return orderPrice / LOTTO_PRICE;
    }

    @Override
    public List<Lotto> createLottos(int orderQuantity) {
        return lottoFactory.createLottos(orderQuantity);
    }

    @Override
    public WinningLotto createWinningLotto(List<Integer> lottoNumbers, int bonusNumber) {
        return new WinningLotto(lottoFactory.createLotto(lottoNumbers), bonusNumber);
    }

    @Override
    public List<LottoResult> getLottoResults(WinningLotto winningLotto, List<Lotto> userLottos) {
        return lottoAccountant.getLottoResults(winningLotto, userLottos);
    }

    @Override
    public float calculateRateOfReturn(List<LottoResult> lottoResults) {
        return lottoAccountant.calculateRateOfReturn(lottoResults, LOTTO_PRICE);
    }
}
