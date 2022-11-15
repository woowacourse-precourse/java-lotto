package lotto;

import static lotto.option.IntegerOption.*;
import static lotto.option.StringOption.*;

public enum Winning {
    FIFTH(FIFTH_PRICE.option,FIFTH_MATCH.option,FIFTH_PRICE_TEXT.option,false),
    FOURTH(FOURTH_PRICE.option,FOURTH_MATCH.option,FOURTH_PRICE_TEXT.option,false),
    THIRD(THIRD_PRICE.option,THIRD_MATCH.option,THIRD_PRICE_TEXT.option,false),
    SECOND(SECOND_PRICE.option,SECOND_MATCH.option,SECOND_PRICE_TEXT.option,true),
    FIRST(FIRST_PRICE.option, FIRST_MATCH.option,FIRST_PRICE_TEXT.option,false);
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
