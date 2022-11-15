package Info;

public enum LottoPoint {
    BONNUS_POINT(10),
    CORRECT_POINT(1),
    WRONG_POINT(0);

    private final int point;

    LottoPoint(int point) {
        this.point = point;
    }

    public int getPoint() {
        return point;
    }
}
