package lotto;

import controller.LottoGameController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    	try {
    		LottoGameController lottoGame = new LottoGameController();
    		lottoGame.gameProgress();
    	} catch (IllegalArgumentException e) {
    		System.out.println(e.getMessage());
    	}
    }
}