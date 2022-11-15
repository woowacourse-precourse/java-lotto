package lotto.ui;

public enum Prize {
	FIRST_DISPLAY("6개 일치 (2,000,000,000원) - "),
	SECOND_DISPLAY("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
	THIRD_DISPLAY("5개 일치 (1,500,000원) - "),
	FOURTH_DISPLAY("4개 일치 (50,000원) - "),
	FIFTH_DISPLAY("3개 일치 (5,000원) - ");

	private final String money;

	Prize(String money){
		this.money = money;
	}

	public String getMoney(){
		return money;
	}
}
