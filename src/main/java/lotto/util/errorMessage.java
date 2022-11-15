package lotto.util;

public enum errorMessage {
	ONLY_INPUT_INTEGER("Integer 값만 입력할 수 있습니다."),
	ONLY_INPUT_BETWEEN_1_45("1~45 범위의 값만 입력할 수 있습니다."),
	ONLY_INPUT_THOUSAND_UNIT("1,000원 단위의 예산만 입력할 수 있습니다."),
	ONLY_INPUT_SIX_NUMBERS("6개의 번호를 입력해야 합니다."),
	DUPLICATED_NUMBER("당첨번호에 중복값이 존재합니다."),
	DUPLICATE_BONUS_NUMBER("보너스번호가 당첨번호와 중복됩니다.");

	private final String description;

	errorMessage(String description) {
		this.description = description;
	}

	public String getValue() {
		return "[ERROR]" + description;
	}
}
