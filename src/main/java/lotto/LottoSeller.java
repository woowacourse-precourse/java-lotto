package lotto;

import java.util.List;

public class LottoSeller {
    public List<Lotto> sellTo(int amount) {
        int numOfLotto = numberOfLotto(amount);
        LottoGenerator lottogenerator = new LottoGenerator();

        return lottogenerator.generateLotto(numOfLotto);
    }

    private int numberOfLotto(int amount) {
        return amount/1000;
    }
}
