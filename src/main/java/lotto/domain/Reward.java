package lotto.domain;

public enum Reward {
    THREE(3,"5,000원",false),
    FOUR(4,"50,000원",false),
    FIVE(5,"1,500,000원",false),
    FIVE_BONUS(5,"30,000,000원",true),
    SIX(6,"2,000,000,000원",true);

    private int bonusNumber;
    private boolean bonusCheck;
    private int number;
    private String bill;

    Reward(int number, String bill,Boolean bonusCheck){
        this.number = number;
        this.bill = bill;
        this.bonusCheck =bonusCheck;
    }


    public void setBonusNumber(int number){
        this.bonusNumber = number;
    }

    public int getBonusNumber(){
        return bonusNumber;
    }




}
