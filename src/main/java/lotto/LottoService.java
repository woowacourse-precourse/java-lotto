package lotto;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinningLotto;
import lotto.model.WinningType;
import lotto.util.RandomNumberGenerator;
import lotto.util.TypeConverter;

import java.util.*;

public class LottoService {
    public static final int FIRST_PRIZE = 1;
    public static final int SECOND_PRIZE = 2;
    public static final int THIRD_PRIZE = 3;
    public static final int FOURTH_PRIZE = 4;
    public static final int FIFTH_PRIZE = 5;
    public static final int LOOSE = -1;
    public static final List<Integer> PRIZES = List.of(FIFTH_PRIZE, FOURTH_PRIZE, THIRD_PRIZE, SECOND_PRIZE, FIRST_PRIZE);
    public static final List<Integer> PRIZE_MONEY = WinningType.getMoneyList();
    public static final int UNIT_MONEY = 1000;

    public int calBuyingCount(int money) {
        return money / UNIT_MONEY;
    }

    public Lottos getLottos(int number) {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < number; count++) {
            lottos.add(getNewLotto());
        }
        return new Lottos(lottos);
    }

    public Lotto getNewLotto() {
        List<Integer> lottoNumbers = RandomNumberGenerator.makeRandomNumbers();
        return new Lotto(lottoNumbers);
    }

    public List<Integer> getWinningResult(WinningLotto winningLotto, Lottos lottos) {
        HashMap<Integer, Integer> result = new HashMap<>();
        for (Lotto lotto : lottos.getLottos()) {
            int prize = calPrize(winningLotto, lotto);
            updateResult(result, prize);
        }
        return TypeConverter.convertResultMapToResultList(result);
    }

    private static void updateResult(HashMap<Integer, Integer> resultMap, int prize) {
        int count = resultMap.getOrDefault(prize, 0) + 1;
        resultMap.put(prize, count);
    }

    public int calPrize(WinningLotto winningLotto, Lotto lotto) {
        Lotto WinningLottoNumber = winningLotto.getLotto();
        int bonusNumber = winningLotto.getBonusNumber();

        int countOfNumbersMatchWinningLotto = getCountOfNumbersMatchWinningLotto(WinningLottoNumber, lotto);

        if (countOfNumbersMatchWinningLotto != 5) {
            return getPrizeByMatchCount(countOfNumbersMatchWinningLotto);
        }
        return getPrizeByBonusNumber(bonusNumber, lotto);
    }

    public int getCountOfNumbersMatchWinningLotto(Lotto winningLotto, Lotto buyingLotto) {
        int countOfNumber = 0;
        Set<Integer> lottoNumberSet = new HashSet<>(winningLotto.getNumbers());
        List<Integer> numbers = buyingLotto.getNumbers();

        for (int number : numbers) {
            if (lottoNumberSet.contains(number)) {
                countOfNumber++;
            }
        }
        return countOfNumber;
    }

    private int getPrizeByMatchCount(int countOfNumbersMatch) {
        if (countOfNumbersMatch == 3) {
            return FIFTH_PRIZE;
        }
        if (countOfNumbersMatch == 4) {
            return FOURTH_PRIZE;
        }
        if (countOfNumbersMatch == 6) {
            return FIRST_PRIZE;
        }
        return LOOSE;
    }

    private int getPrizeByBonusNumber(int bonusNumber, Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        if (lottoNumbers.contains(bonusNumber)) {
            return SECOND_PRIZE;
        }
        return THIRD_PRIZE;
    }

    public double getRateOfReturn(int money, List<Integer> result) {
        int prizeMoney = calPrizeMoney(result);
        return calRatePercent(money, prizeMoney);
    }

    public double calRatePercent(int money, int prizeMoney) {
        return (double) prizeMoney / money * 100;
    }

    public int calPrizeMoney(List<Integer> result) {
        int prizeMoney = 0;
        for (int prize = 5; prize >= 1; prize--) {
            int prizeIndex = 5 - prize;
            prizeMoney += result.get(prizeIndex) * PRIZE_MONEY.get(prizeIndex);
        }
        return prizeMoney;
    }
}
