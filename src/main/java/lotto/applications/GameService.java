package lotto.applications;

import lotto.domains.Lotto;
import lotto.utils.Calculator;
import lotto.utils.LottoNumberMaker;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    private static GameService INSTANCE;

    private GameService() {
    }

    public static GameService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GameService();
        }
        return INSTANCE;
    }

    public int getNumberOfLotto(final int money) {
        return Calculator.calculateNumberOfLotto(money);
    }

    public List<Lotto> createLotteries(final int numberOfLotto) {
        List<Lotto> lottoNumbers = new ArrayList<>();

        for (int i = 0; i < numberOfLotto; i++) {
            Lotto lotto = LottoNumberMaker.createLottoNumbers();
            lottoNumbers.add(lotto);
        }
        return lottoNumbers;
    }
}
