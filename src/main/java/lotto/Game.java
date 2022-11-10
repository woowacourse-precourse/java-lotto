package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Game {
    int gameNumber; // TODO : test 이후 private로 다시 변경

    int[] result;
    Lotto[] games; // TODO : test 이후 private로 다시 변경
//    User user;

    public Game(int money) {
//        this.user = user;
        this.gameNumber = money / 1000;
        this.games = new Lotto[gameNumber];
        this.result = new int[5]; // 1 ~ 5등
    }

    public void generateGame() {
        for (int i = 0; i < gameNumber; i++) {
            games[i] = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
    }

    public boolean checkBonusNumber(List<Integer> gameNumbers, int bonusNumber) {
        return gameNumbers.contains(bonusNumber);
    }

    public String compareNumbers(List<Integer> gameNumbers, User user) {
        int count = 0;
        for (int gameNumber : gameNumbers) {
            if (user.getWinningNumbers().contains(gameNumber)) count++;
        }
        if (count == 6) return "FIRST";
        if (count == 5 && checkBonusNumber(gameNumbers, user.getBonusNumber())) return "SECOND";
        if (count == 5) return "THIRD";
        if (count == 4) return "FORTH";
        if (count == 3) return "FIFTH";
        return "NOTHING";
    }

    public void calculateResult(User user) {
        for (Lotto gameI : this.games) {
            String resultI = compareNumbers(gameI.getNumbers(), user);
            if (resultI.equals("NOTHING")) continue;
            result[Rank.valueOf(resultI).getRank() - 1]++;
        }
    }
}
