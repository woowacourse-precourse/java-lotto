package lotto.system.exception;

public class ConverterNotFoundException extends IllegalStateException {
	public static final String CONVERTER_NOT_FOUND_MESSAGE = "입력된 값에 알맞는 Converter 를 찾지 못했습니다.";

	public ConverterNotFoundException() {
		super(CONVERTER_NOT_FOUND_MESSAGE);
	}
}
