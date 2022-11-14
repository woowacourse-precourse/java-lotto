package domain;

import lotto.Lotto;

import java.util.*;

import static util.Constant.*;

// 특정 사용자의 로또 발행/결과 조회 등 종합 서비스를 제공하는 클래스
public class LottoService {

    private int totalEarning;
    private int money;

    public LottoService() {
        this.totalEarning = 0;
        this.money = 0;
    }

    public int getNumberOfLotto(String moneyInput) {
        int money = InputConverter.getMoney(moneyInput);
        this.money = money;
        return money / LOTTO_PRICE;
    }

    public List<Lotto> publishLotto(int numberOfLotto) {
        List<Lotto> publishedLotto = new ArrayList<>();
        while (numberOfLotto > 0) {
            List<Integer> userLottoNumbers = NumberGenerator.createUniqueRandomNumbers();
            Lotto lotto = new Lotto(userLottoNumbers);

            publishedLotto.add(lotto);
            numberOfLotto--;
        }
        return publishedLotto;
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

        return saveWinningDetails(prizes);
    }

    public double getEarningRate() {
        double earningRate = (double) this.totalEarning / this.money * 100;
        return Math.round(earningRate * 100) / (double) 100;
    }

    private Prize getResultOfLotto(
            List<Integer> winningNumbers,
            List<Integer> userNumbers,
            int bonusNumber
    ) {
        Result result = new Result();
        Prize prize = result.getLottoPrizeResult(winningNumbers, userNumbers, bonusNumber);
        earnMoney(prize.rankingPrize);
        return prize;
    }

    private Map<Prize, Integer> saveWinningDetails(List<Prize> prizes) {
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
