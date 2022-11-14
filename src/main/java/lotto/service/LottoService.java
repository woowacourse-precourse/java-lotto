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
        return createBuyingResultMessage();
    }


    public int getCountOfLotto() {
        return lottoRepository.findAll()
                .size();
    }

    public List<String> createBuyingResultMessage() {
        return List.of(String.valueOf(getCountOfLotto()), createBuyingLottoMessage());
    }

    private String createBuyingLottoMessage() {
        StringBuilder allLottoNumber = new StringBuilder();
        lottoRepository.findAll()
                .stream()
                .map(Lotto::createMessage)
                .forEach(lotto -> allLottoNumber.append(lotto)
                        .append(NEXT_LINE));
        return allLottoNumber.deleteCharAt(allLottoNumber.length() - ONE)
                .toString();
    }
}
