package lotto.serviceImpl;

import lotto.service.GameService;

public class ExceptionGameServiceImpl implements GameService {

    GameService gameService;

    public ExceptionGameServiceImpl(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public void startGame() {
        try {
            gameService.startGame();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
