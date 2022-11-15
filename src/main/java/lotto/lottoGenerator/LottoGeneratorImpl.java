package lotto.lottoGenerator;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.constants.ExceptionMessage.SHOULD_BY_ATLEAST_ONE;

public class LottoGeneratorImpl implements LottoGenerator{
    private RandomNumbersGenerator randomNumbersGenerator;

    public LottoGeneratorImpl(RandomNumbersGenerator randomNumbersGenerator) {
        this.randomNumbersGenerator = randomNumbersGenerator;
    }

    @Override
    public List<Lotto> issueLottosByInputAmount(int numberOfLottos) {
        if(numberOfLottos < 1) {
            throw new IllegalArgumentException(SHOULD_BY_ATLEAST_ONE);
        }
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < numberOfLottos; i++) {
            Lotto lotto = new Lotto(randomNumbersGenerator.generateRandomNumbers());
            lottos.add(lotto);
        }
        return lottos;
    }
}
