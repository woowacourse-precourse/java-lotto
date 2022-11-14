package lotto.enums;

import java.util.Arrays;

public enum Rank {
	FIRST(1, 6, 2000000000, "6개 일치 (2,000,000,000원) - %d개"),
	SECOND(2, 5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
	THIRD(3, 5, 1500000, "5개 일치 (1,500,000원) - %d개"),
	FORTH(4, 4,  50000, "4개 일치 (50,000원) - %d개"),
	FIFTH(5, 3, 5000, "3개 일치 (5,000원) - %d개"),
	SIXTH(6, 0, 0, "낫싱");

	private final int rank;
	private final int matchCount;
	private final String message;
	private final int money;

	Rank(int rank, int matchCount, int money, String message){
		this.rank = rank;
		this.matchCount = matchCount;
		this.money = money;
		this.message = message;
	}

	public static Rank findByRank(int rank){
		return Arrays.stream(Rank.values())
				.filter(prize -> prize.rank == rank)
				.findAny()
				.orElseThrow(() -> new RuntimeException("No matched Rank"));
	}

	public int getRank() {
		return rank;
	}

	public int getMatchCount() {
		return matchCount;
	}

	public String getMessage(){
		return message;
	}



	public int getMoney() {
		return money;
	}
}
