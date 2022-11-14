package lotto.enums;

public enum Constant {
	START_RANGE(1),
	END_RANGE(45),
	UNIT(1000),
	LOTTO_COST(1000),
	LOTTO_SIZE(6);

	private final int value;

	Constant(int value){
		this.value = value;
	}

	public int getValue(){
		return this.value;
	}
}
