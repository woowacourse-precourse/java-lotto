package lotto;

import java.util.function.Function;

public enum LottoWinMoney {
	CALC_5(value -> value * 5000),
	CALC_4(value -> value * 50000),
	CALC_3(value -> value * 1500000),
	CALC_2(value -> value * 30000000),
	CALC_1(value -> value * 2000000000);


	private Function<Integer,Integer> expression;

	LottoWinMoney(Function<Integer,Integer> expression) { this.expression = expression;}

	public long calculate(Integer value) {return expression.apply(value);}
}
