package lotto.config;

public enum LottoStatus {
    INVALID(-1),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX_WITH_BONUS(6),
    SIX(7);

    private final int sameNumber;

    private LottoStatus(int sameNumber) {
        this.sameNumber = sameNumber;
    }

    public LottoStatus getStatus(int key) {

        if (key == THREE.getSameNumber()) {
            return THREE;
        }

        if (key == FOUR.getSameNumber()) {
            return FOUR;
        }

        if (key == FIVE.getSameNumber()) {
            return FIVE;
        }

        if (key == SIX_WITH_BONUS.getSameNumber()) {
            return SIX_WITH_BONUS;
        }

        if (key == SIX.getSameNumber()) {
            return SIX;
        }

        return INVALID;

    }

    public int getSameNumber() {
        return sameNumber;
    }
}
