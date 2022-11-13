package lotto;

import java.util.List;

import static lotto.Game.winning;

public enum Winning {
    FIFTH(5000,3,"5,000원",false),
    FOURTH(50000,4,"50,000원",false),
    THIRD(1500000,5,"1,500,000원",false),
    SECOND(30000000,5,"30,000,000원",true),
    FIRST(2000000000,6,"2,000,000,000원",false);
    public Integer match;
    public Integer price;
    public String priceText;
    public Boolean bonus;
    public Integer count = 0;
    Winning(Integer price, Integer match,String priceText, boolean bonus){
        this.price = price;
        this.match = match;
        this.bonus = bonus;
        this.priceText = priceText;
    }
    public Integer getCount(){
        return this.count;
    }
    public void setCount(Integer count){
        this.count = count;
    }
}
