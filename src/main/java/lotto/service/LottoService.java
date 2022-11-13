package lotto.service;

import lotto.repository.LottoRepository;

public class LottoService {
    public static final int LOTTO_PRICE = 1000;
    private final LottoRepository lottoRepository = LottoRepository.getInstance();

    public void buyLottos(int inputPrice) {
        lottoRepository.generateLottos(inputPrice / LOTTO_PRICE);
    }


    public int getCountOfLotto() {
        return lottoRepository.findAll()
                .size();
    }
}
