package lotto.message;

public interface ErrorMessageConstants {

	String USER_INPUT_ERROR_MESSAGE = "[ERROR] 잘못된 입력입니다.\n";
	String RANGE_ERROR_MESSAGE_FORMAT = "[ERROR] 로또 번호는 %d부터 %d 사이의 숫자여야 합니다.\n";
	String UNIT_ERROR_MESSAGE_FORMAT = "[ERROR] 구입금액은 %d 단위여야 합니다.\n";
	String DUPLICATION_ERROR_MESSAGE = "[ERROR] 중복된 로또 번호입니다.\n";
	String SIZE_ERROR_MESSAGE_FORMAT = "[ERROR] 번호는 %d개만 입력 가능합니다.\n";
}
