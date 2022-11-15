package player;

import java.util.List;

public class Player {
	public static void start() {
		try {
			int coin = Coin.CoinIn();
			CoinErrorCheck.CEC(coin);
			int chance = Chance.run(coin);
			List<List<Integer>> playerPick = PlayerChoose.run(chance);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
}
