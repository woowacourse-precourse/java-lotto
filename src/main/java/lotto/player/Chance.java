package player;

public class Chance {
	public static int run(int Coin) {
		int chance = Coin/1000;
		System.out.println(chance+"개를 구매했습니다.");
		return chance;
	}
}
