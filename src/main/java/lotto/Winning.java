package lotto;

import static lotto.option.Option.*;

public enum Winning {
    FIFTH(FIFTH_PRICE.option,FIFTH_MATCH.option,"5,000원",false),
    FOURTH(FOURTH_PRICE.option,FOURTH_MATCH.option,"50,000원",false),
    THIRD(THIRD_PRICE.option,THIRD_MATCH.option,"1,500,000원",false),
    SECOND(SECOND_PRICE.option,SECOND_MATCH.option,"30,000,000원",true),
    FIRST(FIRST_PRICE.option, FIRST_MATCH.option,"2,000,000,000원",false);
    public Integer match;
    public Integer price;
    public String priceText;
    public Boolean bonus;
    public Integer count = ZERO.option;
    Winning(Integer price, Integer match,String priceText, boolean bonus){
        this.price = price;
        this.match = match;
        this.bonus = bonus;
        this.priceText = priceText;
    }
}
