package resource;

public class ErrorMessage {
    // 당첨 번호 입력시
    public static final String OUT_OF_RANGE_ERROR = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String OUT_OF_SIZE_ERROR = "[ERROR] 로또 번호는 총 6개여야 합니다.";
    public static final String DUPLICATE_ERROR = "[ERROR] 중복된 번호는 선택할 수 없습니다.";
    public static final String NOT_NUMBER_ERROR = "[ERROR] 숫자만 입력이 가능합니다.";

    // 로또 구입 금액 입력시
    public static final String OUT_OF_PURCHASE_AMOUNT_ERROR = "[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.";

}
