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
        validateIsAmountThousandWon(money);
        this.money = money;
        getLotto(money);
    }

    private void validateIsAmountThousandWon(int convertedAmount) {
        if (convertedAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원으로 나누어 떨어져야 합니다.");
        }
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
        return (totalRevenue / investment) * 100;
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
