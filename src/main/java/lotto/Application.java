package lotto;

import lotto.domain.game.LottoGame;
import lotto.system.IoSystemImpl;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        var game = new LottoGame(new IoSystemImpl());
        game.execute();

    }
}
