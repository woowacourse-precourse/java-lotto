package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.repository.LottoRepository;

public class LottoService {
    public static final int LOTTO_PRICE = 1000;
    public static final String NEXT_LINE = "\n";
    public static final int ONE = 1;
    private final LottoRepository lottoRepository = LottoRepository.getInstance();

    public List<String> buyLottos(int inputPrice) {
        lottoRepository.generateLottos(inputPrice / LOTTO_PRICE);
        return createBoughtResultMessage();
    }


    public int getCountOfLotto() {
        return lottoRepository.findAll()
                .size();
    }

    public List<String> createBoughtResultMessage() {
        StringBuilder allLottoNumber = new StringBuilder();
        List<Lotto> lottos = lottoRepository.findAll();
        lottos.stream()
                .map(Lotto::toString)
                .limit(lottos.size() - ONE)
                .forEach(lotto -> allLottoNumber.append(lotto)
                        .append(NEXT_LINE));
        allLottoNumber.append(lottos.get(lottos.size() - ONE)
                .toString());
        return List.of(String.valueOf(getCountOfLotto()), allLottoNumber.toString());
    }
}
