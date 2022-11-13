package domain;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

import static util.Constant.LOTTO_PRICE;

public class LottoService {

    private int totalEarning;
    private List<Prize> userPrizes;
    private int money=0;

    public LottoService() {
        this.totalEarning = 0;
        this.userPrizes = new ArrayList<>();
    }

    public Prize getResultOfLotto(
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
        userPrizes.add(prize);
        earnMoney(prize.rankingPrize);
        return prize;
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

    public int getNumberOfLotto(String moneyInput) {
        int money = InputConverter.getMoney(moneyInput);
        this.money = money;
        return money / LOTTO_PRICE;
    }

    private void earnMoney(int prize) {
        this.totalEarning += prize;
    }
}
