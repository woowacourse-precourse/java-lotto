package lotto.applications;

import lotto.utils.Calculator;

public class GameService {
    private static GameService INSTANCE;

    private GameService() {
    }

    public static GameService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GameService();
        }
        return INSTANCE;
    }

    public int getNumberOfLotto(final int money) {
        return Calculator.calculateNumberOfLotto(money);
    }
}
