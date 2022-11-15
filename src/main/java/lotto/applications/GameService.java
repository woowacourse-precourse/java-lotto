package lotto.applications;

import lotto.domains.Lotto;
import lotto.domains.Place;
import lotto.utils.Calculator;
import lotto.utils.LottoNumberConverter;
import lotto.utils.LottoNumberMaker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameService {
    private static GameService INSTANCE;

    private final Map<Place, Integer> prizeMap = new HashMap<>();
    {
        prizeMap.put(Place.FIRST, 0);
        prizeMap.put(Place.SECOND, 0);
        prizeMap.put(Place.THIRD, 0);
        prizeMap.put(Place.FOURTH, 0);
        prizeMap.put(Place.FIFTH, 0);
        prizeMap.put(Place.ZERO, 0);
    }

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

    public Map<Place, Integer> getRewardMap(
            final List<Lotto> userBoughtLotteries,
            final Lotto winningLotto
    ) {
        final int bonusNumber = winningLotto.getBonusNumber();
        List<List<Integer>> convertedUserLotteries = LottoNumberConverter
                .convertTo2DimensionalList(userBoughtLotteries);

        List<Integer> winningNumbers = winningLotto.getNumbers();
        for (List<Integer> userLotto : convertedUserLotteries) {
            Place place = Calculator.calculatePrize(userLotto, winningNumbers, bonusNumber);
            prizeMap.put(place, prizeMap.get(place) + 1);
        }
        return prizeMap;
    }
}
