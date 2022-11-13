package lotto;

import java.util.ArrayList;
import java.util.List;

public class Player {

    public int firstPlace = 0;
    public int secondPlace = 0;
    public int thirdPlace = 0;
    public int fourthPlace = 0;
    public int fifthPlace = 0;
    private final int money;
    private final int LOTTO_PRICE = 1000;

    public List<Lotto> playerLotto = new ArrayList<>();

    public Player(int money) {
        this.money = money;
        getLotto(money);
    }

    public void playTheLottery(WinningNumbers winningNumbers) {
        RewardsMapper rewardsMapper = new RewardsMapper(winningNumbers);
        int lottoSize = playerLotto.size();

        for (int idx=0; idx<lottoSize; idx++) {
            Lotto lotto = playerLotto.get(idx);
            Rewards matchedReward = rewardsMapper.getReward(lotto);
            if (matchedReward == Rewards.FIRST_PLACE) firstPlace++;
            if (matchedReward == Rewards.SECOND_PLACE) secondPlace++;
            if (matchedReward == Rewards.THIRD_PLACE) thirdPlace++;
            if (matchedReward == Rewards.FOURTH_PLACE) fourthPlace++;
            if (matchedReward == Rewards.FIFTH_PLACE) fifthPlace++;
        }
    }

    public double getLotteryYield() {
        double totalRevenue = getRevenue();
        double investment = getMoney();
        double lotteryYield = (totalRevenue / investment)*100;
        return lotteryYield;
    }

    private void getLotto(int money) {
        int count = 0;
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        while (count < money / LOTTO_PRICE) {
            List<Integer> randomNumber = lottoNumberGenerator.generateLottoNumbers();
            Lotto lotto = new Lotto(randomNumber);
            lotto.generateBonusNumber();
            this.playerLotto.add(lotto);
            count++;
        }
    }

    private int getRevenue() {
        Rewards.values();
        int fifthRevenue = Rewards.FIFTH_PLACE.reward * fifthPlace;
        int fourthRevenue = Rewards.FOURTH_PLACE.reward * fourthPlace;
        int thirdRevenue = Rewards.THIRD_PLACE.reward * thirdPlace;
        int secondRevenue = Rewards.SECOND_PLACE.reward * secondPlace;
        int firstRevenue = Rewards.FIRST_PLACE.reward * firstPlace;
        return fifthRevenue + fourthRevenue + thirdRevenue + secondRevenue + firstRevenue;
    }

    private int getMoney() {
        return this.money;
    }
}
