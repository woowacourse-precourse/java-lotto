package lotto.constant;

public enum WinningConstants {

    FIFTH_PLACE(5, 3, false, 5_000),
    FOURTH_PLACE(4, 4, false, 50_000),
    THIRD_PLACE(3, 5, false, 1_500_000),
    SECOND_PLACE(2, 5, true, 30_000_000),
    FIRST_PLACE(1, 6, false, 2_000_000_000);

    private final int place;
    private final int requiredWinningNumber;
    private final boolean needsBonusNumber;
    private final int reward;
    private final String message;

    WinningConstants(int place, int requiredWinningNumber, boolean needsBonusNumber, int reward) {
        this.place = place;
        this.requiredWinningNumber = requiredWinningNumber;
        this.needsBonusNumber = needsBonusNumber;
        this.reward = reward;
        this.message = makeMessage(requiredWinningNumber, needsBonusNumber, reward);
    }

    private String makeMessage(int requiredWinningNumber, boolean hasBonusNumber, int reward) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("%d개 일치");
        if (hasBonusNumber) {
            stringBuilder.append(", 보너스 볼 일치");
        }
        stringBuilder.append(" (%,d원) - %%d개");

        String message = stringBuilder.toString();
        return String.format(message, requiredWinningNumber, reward);
    }

    public int getPlace() {
        return place;
    }

    public int getRequiredWinningNumber() {
        return requiredWinningNumber;
    }

    public boolean getNeedsBonusNumber() {
        return needsBonusNumber;
    }

    public int getReward() {
        return reward;
    }

    public String getMessage() {
        return message;
    }
}
