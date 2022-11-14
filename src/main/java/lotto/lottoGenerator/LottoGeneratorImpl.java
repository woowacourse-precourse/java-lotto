package lotto.lottoGenerator;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGeneratorImpl implements LottoGenerator{
    private RandomNumbersGenerator randomNumbersGenerator;

    public LottoGeneratorImpl(RandomNumbersGenerator randomNumbersGenerator) {
        this.randomNumbersGenerator = randomNumbersGenerator;
    }

    @Override
    public List<Lotto> issueLottosByInputAmount(int numberOfLottos) {
        if(numberOfLottos < 1) {
            throw new IllegalArgumentException("[ERROR] 로또 발급은 1개 이상만 가능합니다.");
        }
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < numberOfLottos; i++) {
            Lotto lotto = new Lotto(randomNumbersGenerator.generateRandomNumbers());
            lottos.add(lotto);
        }
        return lottos;
    }

    @Override
    public List<Lotto> printLottos(List<Lotto> lottos) {
        return null;
    }
}
