package lotto.utils.game;

public enum GameStatus {
    PURCHASE_AMOUNT,
    WINNING_LOTTO,
    BONUS_NUMBER,
    APPLICATION_EXIT,
    APPLICATION_EXCEPTION;

    public boolean playable() {
        return (this != APPLICATION_EXIT && this != APPLICATION_EXCEPTION);
    }
}
