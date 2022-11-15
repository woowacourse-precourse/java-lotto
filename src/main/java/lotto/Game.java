package lotto;

import java.util.List;

public class Game {

    private Player player;
    private RandomLotto randomLotto;
    private int reward;
    private int match6Count;
    private int match5BonusCount;
    private int match5Count;
    private int match4Count;
    private int match3Count;

    public Game() {
        player = new Player();
        randomLotto = new RandomLotto();
        reward = 0;
        match6Count = 0;
        match5Count = 0;
        match5BonusCount = 0;
        match4Count = 0;
        match3Count = 0;
    }

    public int getReward() {
        return reward;
    }

    public void start() {
        player.buyLotto(); //로또 구매
        List<Lotto> randomLottos = randomLotto.getRandomLottos(player.getLottoCount()); //구매개수만큼 로또 생성
        player.getLottoNum();

        Lotto lotto = player.getLotto();
        Integer bonus = player.getBonus();
        matchLottos(randomLottos, lotto, bonus);
        printMatch();
    }

    public void matchLottos(List<Lotto> randomLottos, Lotto lotto, Integer bonus) {
        for (Lotto randomLotto : randomLottos) {
            Win win = matchLotto(randomLotto, lotto, bonus);
            if (win == Win.MATCH6) {
                reward += Win.MATCH6.getReward();
                match6Count += 1;
            }
            if (win == Win.MATCH5) {
                reward += Win.MATCH5.getReward();
                match5Count += 1;
            }
            if (win == Win.MATCH5BONUS) {
                reward += Win.MATCH5BONUS.getReward();
                match5BonusCount += 1;
            }
            if (win == Win.MATCH4) {
                reward += Win.MATCH4.getReward();
                match4Count += 1;
            }
            if (win == Win.MATCH3) {
                reward += Win.MATCH3.getReward();
                match3Count += 1;
            }
        }
    }

    public Win matchLotto(Lotto randomLotto, Lotto lotto, Integer bonus) {
        List<Integer> randomNumbers = randomLotto.getNumbers();
        List<Integer> lottoNumbers = lotto.getNumbers();
        int matchCount = 0;
        boolean matchBouns = false;

        for (Integer lottoNumber : lottoNumbers) {
            if (randomNumbers.contains(lottoNumber)) {
                matchCount += 1;
            }
        }

        if (randomNumbers.contains(bonus)) {
            matchBouns = true;
        }

        return getWin(matchCount, matchBouns);
    }

    private Win getWin(int matchCount, boolean matchBouns) {
        if (matchCount == 6) {
            return Win.MATCH6;
        }
        if (matchCount == 5 && matchBouns) {
            return Win.MATCH5BONUS;
        }
        if (matchCount == 5) {
            return Win.MATCH5;
        }
        if (matchCount == 4) {
            return Win.MATCH4;
        }
        if (matchCount == 3) {
            return Win.MATCH3;
        }
        return Win.EMPTY;
    }

    private double getRateofReturn() {
        return Math.round(reward * 1000 / player.getPayMoney()) / 10.0;
    }

    private void printMatch() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(Win.MATCH3.getTitle() + " - " + match3Count + "개");
        System.out.println(Win.MATCH4.getTitle() + " - " + match4Count + "개");
        System.out.println(Win.MATCH5.getTitle() + " - " + match5Count + "개");
        System.out.println(Win.MATCH5BONUS.getTitle() + " - " + match5BonusCount + "개");
        System.out.println(Win.MATCH6.getTitle() + " - " + match6Count + "개");
        System.out.println("총 수익률은 " + getRateofReturn() + "%입니다.");
    }
}
