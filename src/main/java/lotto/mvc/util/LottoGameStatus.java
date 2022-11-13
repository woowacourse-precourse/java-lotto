package lotto.mvc.util;

public enum LottoGameStatus {
    GUIDE_PURCHASE_AMOUNT(ProcessType.INPUT),
    PROCESS_PURCHASE_LOTTO(ProcessType.LOGIC),
    GUIDE_WINNING_NUMBERS(ProcessType.INPUT),
    PROCESS_WINNING_LOTTO(ProcessType.LOGIC),
    GUIDE_BONUS_NUMBER(ProcessType.INPUT),
    PROCESS_LOTTO_RANKING(ProcessType.LOGIC),
    APPLICATION_EXIT(ProcessType.EXIT),
    APPLICATION_EXCEPTION(ProcessType.EXIT);

    static {
        GUIDE_PURCHASE_AMOUNT.nextGameStatus = PROCESS_PURCHASE_LOTTO;
        PROCESS_PURCHASE_LOTTO.nextGameStatus = GUIDE_WINNING_NUMBERS;
        GUIDE_WINNING_NUMBERS.nextGameStatus = PROCESS_WINNING_LOTTO;
        PROCESS_WINNING_LOTTO.nextGameStatus = GUIDE_BONUS_NUMBER;
        GUIDE_BONUS_NUMBER.nextGameStatus = PROCESS_LOTTO_RANKING;
        PROCESS_LOTTO_RANKING.nextGameStatus = APPLICATION_EXIT;
        APPLICATION_EXIT.nextGameStatus = APPLICATION_EXIT;
        APPLICATION_EXCEPTION.nextGameStatus = APPLICATION_EXCEPTION;
    }

    private LottoGameStatus nextGameStatus;
    private final ProcessType processType;

    LottoGameStatus(ProcessType processType) {
        this.processType = processType;
    }

    public LottoGameStatus findNextGameStatus() {
        return nextGameStatus;
    }

    public boolean isInput() {
        return processType == ProcessType.INPUT;
    }

    public boolean isLogic() {
        return processType == ProcessType.LOGIC;
    }

    public boolean isExit() {
        return processType == ProcessType.EXIT;
    }
}
