package lotto.domain;

public enum Reward {
    THREE(3,"5,000원"),
    FOUR(4,"50,000원"),
    FIVE(5,"1,500,000원"),
    FIVE_BONUS(5,"30,000,000원"),
    SIX(6,"2,000,000,000원"),
    NOTHING(0,"0");

    private int number;
    private String bill;

    Reward(int number, String bill){
        this.number = number;
        this.bill = bill;
    }
    public int getNumber(){
        return this.number;
    }
}
