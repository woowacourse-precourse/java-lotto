package constant;

public enum RequireCorrectNumber {
    FIRST_CORRECT(6), SECOND_CORRECT(5), THIRD_CORRECT(5), FOURTH_CORRECT(4), FIFTH_CORRECT(3);


    private final int value;
        RequireCorrectNumber(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
