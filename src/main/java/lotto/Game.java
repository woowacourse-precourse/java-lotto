package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;

public class Game {
    int gameNumber; // TODO : test 이후 private로 다시 변경
    Lotto[] games; // TODO : test 이후 private로 다시 변경

    public Game(int money) {
        this.gameNumber = money / 1000;
        this.games = new Lotto[gameNumber];
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
            user.updateResult(resultI);
        }
//        return user;
    }
}
