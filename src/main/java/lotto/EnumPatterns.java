package lotto;

public enum EnumPatterns {

	BET("^1?[0-9]?[0-9]+000$"),
	WINNING_NUMBERS("^([1-9])|([1-3][0-9])|(4[0-5])$"),
	BONUS_NUMBER("^([1-9])|([1-3][0-9])|(4[0-5])$"),
	FORMAT("%.1f"),
	SPLITTER(",");

	private String value;

	EnumPatterns(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
