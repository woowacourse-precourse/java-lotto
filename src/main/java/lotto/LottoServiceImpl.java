package lotto;

import java.util.List;

public class LottoServiceImpl implements LottoService {
    private final int LOTTO_PRICE = 1000;
    private LottoFactory lottoFactory;

    public LottoServiceImpl(LottoFactory lottoFactory) {
        this.lottoFactory = lottoFactory;
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
}
