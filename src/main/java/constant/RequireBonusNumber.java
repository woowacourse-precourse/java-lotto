package constant;

public enum RequireBonusNumber {
    FIRST_BONUS(0), SECOND_BONUS(1), THIRD_BONUS(0), FOURTH_BONUS(0), FIFTH_BONUS(0);

    private final int value;
    RequireBonusNumber(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
