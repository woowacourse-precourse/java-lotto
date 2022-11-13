package lotto;

import lotto.domain.game.LottoGame;
import lotto.system.IoSystem;
import lotto.system.IoSystemImpl;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        IoSystem io = new IoSystemImpl();
        try {
            var game = new LottoGame(io);
            game.execute();
        } catch (IllegalArgumentException exception) {
            io.println(exception.getMessage());
        }
    }
}
