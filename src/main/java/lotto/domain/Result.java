package lotto.domain;

import java.util.List;

public class Result {
    private final List<PlaceStatus> myPlaces;
    private int FIRST_PLACE = 0;
    private int SECOND_PLACE = 0;
    private int THIRD_PLACE = 0;
    private int FOURTH_PLACE = 0;
    private int FIFTH_PLACE = 0;
    private int NONTHING = 0;

    public Result(List<PlaceStatus> myPlaces) {
        this.myPlaces = myPlaces;
    }

    public void getWinningResult() {
        for (PlaceStatus place : myPlaces) {
            checkPlace(place);
        }
    }

    public int getLottoSize() {
        return this.FIRST_PLACE + this.SECOND_PLACE + this.THIRD_PLACE +
            this.FOURTH_PLACE + this.FIFTH_PLACE + this.NONTHING;
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

        if (place == PlaceStatus.NOTHING) {
            this.NONTHING++;
        }
    }

    public int getFirst() {
        return FIRST_PLACE;
    }

    public int getSecond() {
        return SECOND_PLACE;
    }

    public int getThird() {
        return THIRD_PLACE;
    }

    public int getFourth() {
        return FOURTH_PLACE;
    }

    public int getFifth() {
        return FIFTH_PLACE;
    }

    public int getReward() {
        return (this.FIRST_PLACE * 2000000000) + (this.SECOND_PLACE * 30000000) +
            (this.THIRD_PLACE * 1500000) + (this.FOURTH_PLACE * 50000) + (this.FIFTH_PLACE * 5000);
    }
}
