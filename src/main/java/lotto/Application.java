package lotto;

import lotto.start.gameStart;
import lotto.log.log;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            gameStart gameStart = new gameStart();
            gameStart.run();
        } catch (IllegalArgumentException e) {
            log.error(e.getMessage());
        }

    }

}
