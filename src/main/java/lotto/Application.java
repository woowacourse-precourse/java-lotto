package lotto;

import lotto.config.AppConfig;
import lotto.controller.LottoController;

public class Application {
	public static void main(String[] args) {
		// TODO: 프로그램 구현
		LottoController lottoController = new AppConfig().config();
		lottoController.startApplication();
	}
}
