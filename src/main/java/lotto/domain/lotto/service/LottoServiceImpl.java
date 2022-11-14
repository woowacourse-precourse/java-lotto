package lotto.domain.lotto.service;

public class LottoServiceImpl implements LottoService {

    private final LottoMessenger lottoMessenger;

    public LottoServiceImpl(LottoMessenger lottoMessenger) {
        this.lottoMessenger = lottoMessenger;
    }

    @Override
    public String requestMoney() {
        return lottoMessenger.requestMoney();
    }
}
