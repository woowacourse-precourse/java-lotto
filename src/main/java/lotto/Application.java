package lotto;

import lotto.service.GameService;
import lotto.serviceImpl.ExceptionGameServiceImpl;
import lotto.serviceImpl.LottoGameServiceImpl;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        GameService gameService = new ExceptionGameServiceImpl(new LottoGameServiceImpl());
        gameService.startGame();
    }
}
