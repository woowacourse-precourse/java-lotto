package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoProcessorImpl implements LottoProcessor{

    private final LottoRepository lottoRepository = new LottoRepository();

    //몇개가 일치하는지 알려주는 로직
    @Override
    public int matchLottoNumber(Lotto winLotto, Lotto lotto) {
        int equalCount = 0;
        for(Integer number: lotto.getNumbers()) {
            if (winLotto.getNumbers().contains(number)) {
                equalCount++;
            }
        }
        return equalCount;
    }

    @Override
    public Boolean matchBonusNumber(Integer bonusNumber, Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    @Override
    public List<Lotto> buyLotto(Integer money) {
        List<Lotto> clientLotto = new ArrayList<>();
        int count = money/PriceEnum.LOTTO_PRICE.getValue();

        IntStream.range(0, count)
                .forEach(i -> clientLotto.add(lottoRepository.create()));

        return clientLotto;
    }
}
