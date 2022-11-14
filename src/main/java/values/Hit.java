package values;

import static values.Constants.Console.*;

public enum Hit {
    THREE(THREE_HIT),
    FOUR(FOUR_HIT),
    FIVE(FIVE_HIT),
    FIVE_BONUS(FIVE_BONUS_HIT),
    SIX(SIX_HIT);


    private String message;

    Hit(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

}
