package lotto;

import java.util.List;

import static lotto.Game.winning;
import static lotto.option.Option.*;

public enum Winning {
    FIFTH(FIFTH_PRICE.option,3,"5,000원",false),
    FOURTH(FOURTH_PRICE.option,4,"50,000원",false),
    THIRD(THIRD_PRICE.option,5,"1,500,000원",false),
    SECOND(SECOND_PRICE.option,5,"30,000,000원",true),
    FIRST(FIRST_PRICE.option, 6,"2,000,000,000원",false);
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
