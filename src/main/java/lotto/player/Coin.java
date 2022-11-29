package player;

import camp.nextstep.edu.missionutils.Console;

public class Coin {
	public static int CoinIn() {
		System.out.println("구입금액을 입력해 주세요."	);
		int Coin = Integer.parseInt(Console.readLine());
		return Coin;
	}
}
