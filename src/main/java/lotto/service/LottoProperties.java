package lotto.service;

import java.util.Arrays;
import java.util.function.Function;

public enum LottoProperties {
    LOTTO_FIFTHWINNER(3,correct->0,5000,"5,000원"),
    LOTTO_FOURTHWINNER(4,correct->1, 50000,"50,000원"),
    LOTTO_THIRDWINNER(5,correct->2, 1500000,"1,500,000원"),
    LOTTO_SECONDWINNER(7,correct->3,30000000,"30,000,000원"),
    LOTTO_WINNER(6,correct->4,2000000000,"2,000,000,000원"),
    LOTTO_LOOSE(-1,correct->5,0,"0원");
    int operator;
    Function<Integer,Integer> expression;
    int price;
    String sprice;

    LottoProperties(int operator,Function<Integer,Integer> expression,int price,String sprice) {
        this.operator=operator;
        this.expression = expression;
        this.price = price;
        this.sprice = sprice;
    }
    public static LottoProperties findType(int correct){
        return Arrays.stream(LottoProperties.values())
                .filter(type -> type.operator==correct)
                .findFirst()
                .orElse(LottoProperties.LOTTO_LOOSE);
    }
    public int function(int correct){
        return this.expression.apply(correct);
    }
    public int getOperator(){
        return operator;
    }
    public int getPrice(){
        return price;
    }
    public String getSprice(){
        return sprice;
    }
}
