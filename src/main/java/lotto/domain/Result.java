package lotto.domain;

import java.util.List;

public class Result {
    private final List<PlaceStatus> myPlaces;
    private int FIRST_PLACE = 0;
    private int SECOND_PLACE = 0;
    private int THIRD_PLACE = 0;
    private int FOURTH_PLACE = 0;
    private int FIFTH_PLACE = 0;

    public Result(List<PlaceStatus> myPlaces) {
        this.myPlaces = myPlaces;
    }

    public void getWinningResult() {
        for (PlaceStatus place : myPlaces) {
            checkPlace(place);
        }
    }

    private void checkPlace(PlaceStatus place) {
        if (place == PlaceStatus.FIRST) {
            this.FIRST_PLACE++;
        }

        if (place == PlaceStatus.SECOND) {
            this.SECOND_PLACE++;
        }

        if (place == PlaceStatus.THIRD) {
            this.THIRD_PLACE++;
        }

        if (place == PlaceStatus.FOURTH) {
            this.FOURTH_PLACE++;
        }

        if (place == PlaceStatus.FIFTH) {
            this.FIFTH_PLACE++;
        }
    }
}
