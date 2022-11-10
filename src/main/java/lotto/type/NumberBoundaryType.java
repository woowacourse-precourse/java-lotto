package lotto.type;

public enum NumberBoundaryType {
    MINIMUM_INDEX(0),
    MAXIMUM_INDEX(1);

    private final int boundary;

    NumberBoundaryType(int boundary) {
        this.boundary = boundary;
    }

    public int getBoundary() {
        return boundary;
    }
}
