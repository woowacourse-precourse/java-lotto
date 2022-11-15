package lotto.util;

public enum ERROR_MESSAGE {
    NUMBER_RANGE_EXCEPTION("wef"),
    NUMBER_SIZE_EXCEPTION(""),
    NUMBER_DUPLICATED(""),
    NUMBER_TYPE_EXCEPTION(""),
    PURCHASE_UNIT_ERROR(""),
    ;

    private String message;

    ERROR_MESSAGE(String message) {
        this.message = message;
    }
}
