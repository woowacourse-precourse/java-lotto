package lotto;

import lotto.domain.game.LottoGame;
import lotto.system.IoSystem;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        IoSystem io = new IoSystem();
        try {
            var game = new LottoGame(io);
            game.execute();
        } catch (IllegalArgumentException exception) {
            io.println(exception.getMessage());
        }
    }
}
