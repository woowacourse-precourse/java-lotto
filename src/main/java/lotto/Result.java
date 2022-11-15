package lotto;

import static lotto.ErrorMessage.CANNOT_FIND_RANK;

public enum Result {
    FIFTH(3, 5000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int correctNumbers;
    private final int prizeMoney;
    private int count;

    Result(int correctNumbers, int prizeMoney){
        this.correctNumbers = correctNumbers;
        this.prizeMoney = prizeMoney;
    }

    public static Result getResult(int correctNumbers, boolean bonusNumber){
        if(correctNumbers == SECOND.getCorrectNumbers() && bonusNumber){
            return SECOND;
        }

        for(Result result : Result.values()){
            if(correctNumbers == result.getCorrectNumbers()){
                return result;
            }
        }
        throw new IllegalArgumentException(CANNOT_FIND_RANK);
    }

    public int getCorrectNumbers(){
        return this.correctNumbers;
    }

    public int getPrizeMoney(){
        return this.prizeMoney;
    }

    public int getCount(){
        return this.count;
    }

    public void increaseCount(){
        this.count++;
    }
}
