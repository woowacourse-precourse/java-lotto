package lotto;

public enum WINNINGS{
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000);

    int value;

    private WINNINGS(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}