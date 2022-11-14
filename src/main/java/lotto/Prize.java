package lotto;

import java.util.Arrays;

public enum Prize {
	FIRST(1, 2000000000, "6개 일치 (2,000,000,000원) - %d개"),
	SECOND(2, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
	THIRD(3, 1500000, "5개 일치 (1,500,000원) - %d개"),
	FORTH(4, 50000, "4개 일치 (50,000원) - %d개"),
	FIFTH(5, 5000, "3개 일치 (5,000원) - %d개"),
	SIXTH(6, 0, "낫싱");

	private int rank;
	private String message;
	private int money;

	Prize(int rank,  int money, String message){
		this.rank = rank;
		this.money = money;
		this.message = message;
	}

	public static Prize findByRank(int rank){
		return Arrays.stream(Prize.values())
				.filter(prize -> prize.rank == rank)
				.findAny()
				.orElseThrow(() -> new RuntimeException("No matched Rank"));
	}

	public int getRank() {
		return rank;
	}

	public String getMessage(){
		return message;
	}

	public int getMoney() {
		return money;
	}
}
