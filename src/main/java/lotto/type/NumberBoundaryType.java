package lotto.type;

public enum NumberBoundaryType {
    MINIMUM_INDEX(1),
    MAXIMUM_INDEX(45);

    private final int boundary;

    NumberBoundaryType(int boundary) {
        this.boundary = boundary;
    }

    public int getBoundary() {
        return boundary;
    }
}
