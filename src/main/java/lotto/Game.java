package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Game {
    int gameNumber; // TODO : test 이후 private로 다시 변경
    Lotto[] games; // TODO : test 이후 private로 다시 변경

    public Game(int money) {
        this.gameNumber = money / 1000;
        this.games = new Lotto[this.gameNumber];
//        this.games = new ArrayList<>();
    }

    public void informGameNumber() {
        System.out.printf("%d개를 구매했습니다.%n", this.gameNumber);
        System.out.println();
    }

    public void informGames() {
        for (Lotto gameI : this.games) {
            System.out.println(gameI.getNumbers().toString());
//            System.out.println(Arrays.toString(gameI.getNumbers().toArray()));
//            System.out.println(1);
        }
        System.out.println();
    }

    public void generateGame() {
        for (int i = 0; i < gameNumber; i++) {
            this.games[i] = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
//            this.games.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
//            System.out.println(this.games[i].getNumbers().toString());
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
