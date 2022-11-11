package lotto.domain;

public class Place {

    private final int hasNumberCount;

    public Place(int hasNumberCount) {
        this.hasNumberCount = hasNumberCount;
    }

    public PlaceStatus selectPlace() {
        if (hasNumberCount == 6) {
            return PlaceStatus.FIRST;
        }



        return PlaceStatus.NOTHING;
    }
}
