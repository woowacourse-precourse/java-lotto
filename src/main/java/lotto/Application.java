package lotto;

import lotto.controller.LottoGame;
import lotto.domain.User;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        new LottoGame(new User()).play();
    }
}
