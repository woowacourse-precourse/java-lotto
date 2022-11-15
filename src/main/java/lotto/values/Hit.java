package lotto.values;

import static lotto.values.Constants.Console.*;
import static lotto.values.Constants.Digit.*;

public enum Hit {
    THREE(THREE_HIT_MESSAGE),
    FOUR(FOUR_HIT_MESSAGE),
    FIVE(FIVE_HIT_MESSAGE),
    FIVE_BONUS(FIVE_BONUS_HIT_MESSAGE),
    SIX(SIX_HIT_MESSAGE);


    private final String message;

    Hit(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public static Hit getHit(int rank){
        Hit hit = null;
        if(rank == FIFTH_PLACE){
            hit = Hit.THREE;
        } else if(rank == FOURTH_PLACE){
            hit = Hit.FOUR;
        } else if(rank == THIRD_PLACE) {
            hit = Hit.FIVE;
        } else if (rank == SECOND_PLACE) {
            hit = Hit.FIVE_BONUS;
        } else if (rank == FIRST_PLACE) {
            hit = Hit.SIX;
        }
        return hit;
    }

}
