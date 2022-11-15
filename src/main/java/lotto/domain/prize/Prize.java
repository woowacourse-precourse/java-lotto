package lotto.domain.prize;
//예기치 못한 오류 테스트 커밋
public enum Prize {
	THREE("3개 일치","5,000"),
	FOUR("4개 일치","50,000"),
	FIVE("5개 일치","1,500,000"),
	FIVE_B("5개 일치, 보너스 볼 일치","30,000,000"),
	SIX("6개 일치","2,000,000,000");

	private final String grade;
	private final String prize_money;

	private Prize (String grade,String prize_money){
		this.grade=grade;
		this.prize_money=prize_money;
	}

	public String getGrade() {
		return this.grade;
	}

	public String getPrize_money() {
		return this.prize_money;
	}
}
