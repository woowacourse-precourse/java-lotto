package lotto.values;

public enum Hit {
    THREE(Constants.Console.THREE_HIT_MESSAGE),
    FOUR(Constants.Console.FOUR_HIT_MESSAGE),
    FIVE(Constants.Console.FIVE_HIT_MESSAGE),
    FIVE_BONUS(Constants.Console.FIVE_BONUS_HIT_MESSAGE),
    SIX(Constants.Console.SIX_HIT_MESSAGE);


    private String message;

    Hit(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

}
