package lotto;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private int firstPlace = 0;
    private int secondPlace = 0;
    private int thirdPlace = 0;
    private int fourthPlace = 0;
    private int fifthPlace = 0;
    private List<Lotto> lottery = new ArrayList<>();

    private final int money;
    private final int LOTTO_PRICE = 1000;
    public int getFifthPlace() {
        return fifthPlace;
    }

    public Player(int money) {
        this.money = money;
        getLotto(money);
    }

    public void playTheLottery(WinningNumbers winningNumbers) {
        RewardsMapper rewardsMapper = new RewardsMapper(winningNumbers);
        for (Lotto lotto : lottery) {
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
        double lotteryYield = (totalRevenue / investment) * 100;
        return lotteryYield;
    }

    private void getLotto(int money) {
        int count = 0;
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        while (count < money / LOTTO_PRICE) {
            List<Integer> randomNumber = lottoNumberGenerator.generateLottoNumbers();
            Lotto lotto = new Lotto(randomNumber);
            lotto.generateBonusNumber();
            this.lottery.add(lotto);
            count++;
        }
    }

    private int getRevenue() {
        Rewards.values();
        int fifthRevenue = Rewards.FIFTH_PLACE.getReward() * fifthPlace;
        int fourthRevenue = Rewards.FOURTH_PLACE.getReward() * fourthPlace;
        int thirdRevenue = Rewards.THIRD_PLACE.getReward() * thirdPlace;
        int secondRevenue = Rewards.SECOND_PLACE.getReward() * secondPlace;
        int firstRevenue = Rewards.FIRST_PLACE.getReward() * firstPlace;
        return fifthRevenue + fourthRevenue + thirdRevenue + secondRevenue + firstRevenue;
    }

    public List<Lotto> getLottery() {
        return lottery;
    }

    private int getMoney() {
        return this.money;
    }

    public int getFirstPlace() {
        return firstPlace;
    }

    public int getSecondPlace() {
        return secondPlace;
    }

    public int getThirdPlace() {
        return thirdPlace;
    }

    public int getFourthPlace() {
        return fourthPlace;
    }
}
