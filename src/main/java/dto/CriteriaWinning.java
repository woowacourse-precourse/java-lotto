package dto;

public enum CriteriaWinning {

	R1(1, 2000000000, 6, false)
	,R2(2, 30000000,5, true)
	,R3(3, 1500000,5, false)
	,R4(4, 50000,4, false)
	,R5(5, 5000,3, false);

	private final int rank;
	private final int prizeMoney;
	private final int criteria;
	private final boolean bonus;
	
	private CriteriaWinning(int rank, int prizeMoney, int criteria, boolean bonus) {
		this.rank = rank;
		this.prizeMoney = prizeMoney;
		this.criteria = criteria;
		this.bonus = bonus;
	}

	public int getPrizeMoney() {
		return prizeMoney;
	}

	public int getCriteria() {
		return criteria;
	}
	
	public int getRank() {
		return rank;
	}

	public boolean isBonus() {
		return bonus;
	}
	
	
	
	
	
}
