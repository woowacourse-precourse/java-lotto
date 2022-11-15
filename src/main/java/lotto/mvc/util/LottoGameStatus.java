package lotto.mvc.util;

public enum LottoGameStatus {
    PURCHASE_AMOUNT(ProcessType.RUN),
    WINNING_NUMBERS(ProcessType.RUN),
    BONUS_NUMBER(ProcessType.RUN),
    APPLICATION_EXIT(ProcessType.EXIT),
    APPLICATION_EXCEPTION(ProcessType.EXIT);

    static {
        PURCHASE_AMOUNT.nextGameStatus = WINNING_NUMBERS;
        WINNING_NUMBERS.nextGameStatus = BONUS_NUMBER;
        BONUS_NUMBER.nextGameStatus = APPLICATION_EXIT;
        APPLICATION_EXIT.nextGameStatus = APPLICATION_EXIT;
        APPLICATION_EXCEPTION.nextGameStatus = APPLICATION_EXCEPTION;
    }

    private LottoGameStatus nextGameStatus;
    private final ProcessType processType;

    LottoGameStatus(final ProcessType processType) {
        this.processType = processType;
    }

    public LottoGameStatus findNextGameStatus() {
        return nextGameStatus;
    }

    public boolean isExit() {
        return processType == ProcessType.EXIT;
    }
}
