package lotto.values;

import static lotto.values.Constants.Console.*;

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

}
