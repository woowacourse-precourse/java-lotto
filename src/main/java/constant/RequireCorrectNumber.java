package constant;

import java.util.List;

public enum RequireCorrectNumber {
    FIRST_CORRECT(6), SECOND_CORRECT(5),
    THIRD_CORRECT(5), FOURTH_CORRECT(4),
    FIFTH_CORRECT(3);


    private final int normalNumberCount;

        RequireCorrectNumber(Integer normalNumber){
        this.normalNumberCount = normalNumber;

    }

    public int getValue(){
            return normalNumberCount;
    }

}
