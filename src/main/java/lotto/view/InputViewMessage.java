package lotto.view;

import lotto.util.CharacterUnits;

public enum InputViewMessage {
    INPUT_CASH_MESSAGE("구입금액을 입력해 주세요." + CharacterUnits.ENTER.getUnit()),
    NOTICE_PURCHASE_LOTTO_COUNT("%d개를 구매했습니다." + CharacterUnits.ENTER.getUnit()),
    INPUT_LOTTO_WIN_NUMBER("당첨 번호를 입력해 주세요." + CharacterUnits.ENTER.getUnit()),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요." + CharacterUnits.ENTER.getUnit());

    private final String message;

    InputViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
