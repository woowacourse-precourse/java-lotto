package lotto.domain;

public enum Reward {
    THREE(3,"5,000"),
    FOUR(4,"50,000"),
    FIVE(5,"1,500,000"),
    FIVE_BONUS(5,"30,000,000"),
    SIX(6,"2,000,000,000"),
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
    public String getBIll(){
        return this.bill;
    }
}
