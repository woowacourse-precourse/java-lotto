package lotto;

public enum WinCount {
    THREE_WIN(3),
    TWO_WIN_ONE_BONUS(12),
    FOUR_WIN(4),
    THREE_WIN_ONE_BONUS(13),
    FIVE_WIN(5),
    FOUR_WIN_ONE_BONUS(14),
    SIX_WIN(6),
    FIVE_WIN_ONE_BONUS(15);

    private final int rightCount;

    WinCount(int rightCount){
        this.rightCount= rightCount;
    }

    public int getRightCount(){
        return rightCount;
    }
}
