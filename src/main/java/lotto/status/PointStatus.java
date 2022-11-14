package lotto.status;

public enum PointStatus {
    POINT_OF_FIRST(7),
    POINT_OF_SECOND(6);

    private int number;

    PointStatus(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
