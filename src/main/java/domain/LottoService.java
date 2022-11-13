package domain;

import lotto.Lotto;

import java.util.*;
import java.util.stream.Collectors;

import static util.Constant.LOTTO_PRICE;

public class LottoService {

    private int totalEarning;
    private int money = 0;

    public LottoService() {
        this.totalEarning = 0;
    }

    public Map<Prize, Integer> getWinningDetails(
            List<Integer> winningNumbers,
            List<Lotto> lottos,
            int bonusNumber
    ) {
        List<Prize> prizes = new ArrayList<>();
        for (Lotto lotto : lottos) {
            Prize resultOfLotto = getResultOfLotto(winningNumbers, lotto.getUserLottoNumbers(), bonusNumber);
            prizes.add(resultOfLotto);
        }

        Map<Prize, Integer> resultMap = new HashMap<>();
        initResultMap(resultMap);

        for (Prize prize : prizes) {
            if (prize.equals(Prize.nothing)) {
                continue;
            }
            int numberOfPrize = resultMap.get(prize);
            resultMap.replace(prize, numberOfPrize + 1);
        }
        return resultMap;
    }

    public List<Lotto> publishLotto(int numberOfLotto) {
        List<Lotto> publishedLotto = new ArrayList<>();
        while (numberOfLotto > 0) {
            List<Integer> randomNumbers = NumberGenerator.createUniqueRandomNumbers();
            List<Integer> userLottoNumbers = randomNumbers.stream()
                    .sorted(Comparator.comparing(Math::abs))
                    .collect(Collectors.toList());
            Lotto lotto = new Lotto(userLottoNumbers);

            publishedLotto.add(lotto);
            numberOfLotto--;
        }
        return publishedLotto;
    }

    public int getNumberOfLotto(String moneyInput) {
        int money = InputConverter.getMoney(moneyInput);
        this.money = money;
        return money / LOTTO_PRICE;
    }

    private Prize getResultOfLotto(
            List<Integer> winningNumbers,
            List<Integer> userNumbers,
            int bonusNumber
    ) {
        Result result = new Result();
        int matchingCount = result.countMatchingNumber(winningNumbers, userNumbers);
        boolean checkBonusNumber = false;
        if (matchingCount == 5) {
            checkBonusNumber = result.isMatchingBonusNumber(userNumbers, bonusNumber);
        }
        Rank rank = result.getRank(matchingCount, checkBonusNumber);
        Prize prize = result.getPrize(rank);
        earnMoney(prize.rankingPrize);
        return prize;
    }

    private void earnMoney(int prize) {
        this.totalEarning += prize;
    }

    private void initResultMap(Map<Prize, Integer> resultMap) {
        resultMap.put(Prize.firstPrize, 0);
        resultMap.put(Prize.secondPrize, 0);
        resultMap.put(Prize.thirdPrize, 0);
        resultMap.put(Prize.fourthPrize, 0);
        resultMap.put(Prize.fifthPrize, 0);
    }
}
