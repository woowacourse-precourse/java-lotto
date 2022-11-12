package constant;

public enum RequireCorrectNumber {
    FIRST_CORRECT(6,0), SECOND_CORRECT(5,1),
    THIRD_CORRECT(5,0), FOURTH_CORRECT(4,0),
    FIFTH_CORRECT(3,0);


    private final int normalNumberCount;
    private final int bonusNumberCount;
        RequireCorrectNumber(int normalNumber, int bonusNumber){
        this.normalNumberCount = normalNumber;
        this.bonusNumberCount = bonusNumber;
    }

    public int getNormalCount(){
        return normalNumberCount;
    }
    public int getBonusNumberCount(){
        return bonusNumberCount;
    }
}
