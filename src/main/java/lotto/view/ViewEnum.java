package lotto.view;

public enum ViewEnum {
    NUMBER_OF_USER_PRICE_INPUT_MESSAGE("구입금액을 입력해 주세요."),
    LIST_OF_LOTTO_INPUT_MESSAGE("당첨 번호를 입력해 주세요."),
    EXCEPTED_UNIT_OF_PRICE_MESSAGE("[ERROR] 1,000원 단위의 슷자만 입력 가능합니다."),
    EXCEPTED_LOTTO_MESSAGE("[ERROR] 로또 번호는 1부터 45 사이의 중복되지 않는 6개의 숫자여야 합니다."),
    NUMBER_OF_BONUS_INPUT_MESSAGE("보너스 번호를 입력해 주세요."),

    NUMBER_OF_USER_GAME_COUNT("%d개를 구매했습니다.\n"),
    START_OF_RESULT("당첨 통계 \n---");

    private String message;

    ViewEnum(String message){
        this.message=message;
    }

    public String getMessage() {
        return message;
    }
}
