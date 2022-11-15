package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
	public static void main(String[] args) {
		User user = new User();
		WinningLotto winningLotto = new WinningLotto();

		Statistics statistics = new Statistics(user, winningLotto);
		statistics.compare();
	}
}
