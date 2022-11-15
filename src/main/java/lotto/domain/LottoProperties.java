package lotto.domain;

import java.util.Arrays;

public enum LottoProperties {
    LOTTO_FIFTHWINNER(3,0,5000,"5,000원","%d개 일치 (%s) - %d개\n"),
    LOTTO_FOURTHWINNER(4 , 1,50000,"50,000원","%d개 일치 (%s) - %d개\n"),
    LOTTO_THIRDWINNER(5,2, 1500000,"1,500,000원","%d개 일치 (%s) - %d개\n"),
    LOTTO_SECONDWINNER(5,3,30000000,"30,000,000원","%d개 일치, 보너스 볼 일치 (%s) - %d개\n"),
    LOTTO_WINNER(6,4,2000000000,"2,000,000,000원","%d개 일치 (%s) - %d개\n"),
    LOTTO_LOOSE(-1,5,0,"0원","");
    int correct;
    int index;
    int price;
    String sprice;
    String strResultFormat;
    LottoProperties(int correct,int index,int price,String sprice, String strResultFormat) {
        this.correct=correct;
        this.index =index;
        this.price = price;
        this.sprice = sprice;
        this.strResultFormat = strResultFormat;
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
    public String getStrResultFormat(){
        return strResultFormat;
    }
}
