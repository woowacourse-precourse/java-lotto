package lotto.domain;

import java.util.Arrays;
import java.util.function.Function;

public enum LottoProperties {
    LOTTO_FIFTHWINNER(3,4,5000,"5,000원"),
    LOTTO_FOURTHWINNER(4 , 3,50000,"50,000원"),
    LOTTO_THIRDWINNER(5,2, 1500000,"1,500,000원"),
    LOTTO_SECONDWINNER(5,1,30000000,"30,000,000원"),
    LOTTO_WINNER(6,0,2000000000,"2,000,000,000원"),
    LOTTO_LOOSE(-1,0,0,"0원");
    int correct;
    int index;
    int price;
    String sprice;
    LottoProperties(int correct,int index,int price,String sprice) {
        this.correct=correct;
        this.index =index;
        this.price = price;
        this.sprice = sprice;
    }
    public static LottoProperties findType(int correct){
        return Arrays.stream(LottoProperties.values())
                .filter(type -> type.correct==correct)
                .findFirst()
                .orElse(LottoProperties.LOTTO_LOOSE);
    }
    public int getCorrect(){
        return correct;
    }
    public int getPrice(){
        return price;
    }
    public String getSprice(){
        return sprice;
    }
    public int getIndex(){
        return index;
    }
}
