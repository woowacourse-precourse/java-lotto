package lotto;

import camp.nextstep.edu.missionutils.Randoms;

public class Game {
    int gameNumber; // TODO : test 이후 private로 다시 변경
    Lotto[] games; // TODO : test 이후 private로 다시 변경

    public Game(int money) {
        this.gameNumber = money % 1000;
        this.games = new Lotto[gameNumber];
    }

    public void generateGame() {
        for (int i = 0; i < gameNumber; i++) {
            games[i] = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
    }
}
