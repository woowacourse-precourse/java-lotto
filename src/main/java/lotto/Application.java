package lotto;

import lotto.domain.lotto.LottoGame;

public class Application {

	public static void main(String[] args) {
		// TODO: 프로그램 구현

		try {
			LottoGame lottoGame = new LottoGame();
			lottoGame.start();
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
		}
	}
}
