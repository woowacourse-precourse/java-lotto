package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.domain.WinningType;
import lotto.util.RandomNumberGenerator;

import java.util.*;
import java.util.stream.Collectors;

public class LottoService {
    public static final int FIRST_PRIZE = 1;
    public static final int SECOND_PRIZE = 2;
    public static final int THIRD_PRIZE = 3;
    public static final int FOURTH_PRIZE = 4;
    public static final int FIFTH_PRIZE = 5;
    public static final int LOOSE = -1;
    public static final List<Integer> PRIZES = List.of(FIFTH_PRIZE, FOURTH_PRIZE, THIRD_PRIZE, SECOND_PRIZE, FIRST_PRIZE);
    public static final List<Integer> PRIZE_MONEY = WinningType.getMoneyList();

    public int calBuyingCount(int money) {
        return money / 1000;
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

    public List<Integer> getResult(WinningLotto winningLotto, Lottos lottos) {
        HashMap<Integer, Integer> resultMap = new HashMap<>();
        for (Lotto lotto : lottos.getLottos()) {
            int prize = calPrize(winningLotto, lotto);
            updateResult(resultMap, prize);
        }
        return convertResultMapToResultList(resultMap);
    }

    private List<Integer> convertResultMapToResultList(HashMap<Integer, Integer> resultMap) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int prize : PRIZES) {
            result.add(resultMap.getOrDefault(prize, 0));
        }
        return result;
    }

    private static void updateResult(HashMap<Integer, Integer> resultMap, int prize) {
        for (int prizeNumber : PRIZES) {
            if (prize == prizeNumber) {
                int count = resultMap.getOrDefault(prizeNumber, 0) + 1;
                resultMap.put(prizeNumber, count);
                break;
            }
        }
    }

    public int calPrize(WinningLotto winningLotto, Lotto lotto) {
        Lotto WinningLottoNumber = winningLotto.getLotto();
        int countOfNumbersMatchWinningLotto = getCountOfNumbersMatchWinningLotto(WinningLottoNumber, lotto);
        int bonusNumber = winningLotto.getBonusNumber();

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
        return (double) prizeMoney / money * 100;
    }

    private int calPrizeMoney(List<Integer> result) {
        int prizeMoney = 0;
        for (int prize = 5; prize >= 1; prize--) {
            int prizeIndex = 5 - prize;
            prizeMoney += result.get(prizeIndex) * PRIZE_MONEY.get(prizeIndex);
        }
        return prizeMoney;
    }
}
