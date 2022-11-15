package lotto.domain;

public enum Regex {
	RANGE(String.format("^[%d-9]$|^[1-%d][0-9]|^%d[0-%d]$",
		Number.MIN.getValue(),
		Number.MAX.getValue() / 10 - 1,
		Number.MAX.getValue() / 10,
		Number.MAX.getValue() % 10
	)),
	UNIT("^[0-9]*000$"),
	;

	private final String expression;

	Regex(String expression) {
		this.expression = expression;
	}

	public String getExpression() {
		return expression;
	}
}
