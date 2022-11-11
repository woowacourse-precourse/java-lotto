package lotto;

import java.util.Arrays;

public enum LottoPrice {
    FIRST("6개 일치", "2,000,000,000", 6 ),
    SECOND("5개 일치, 보너스 볼 일치", "30,000,000", 5),
    THIRD("5개 일치", "1,500,000", 5),
    FOURTH("4개 일치", "50,000", 4),
    FIFTH("3개 일치","5,000" , 3);

    private String label , price;
    private int num;
    LottoPrice(String label, String price, int num) {
        this.label = label;
        this.price = price;
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public String getLabel() {
        return label;
    }

    public String getPrice() {
        return price;
    }

    public static LottoPrice valueOfMatchCounts(int matchCounts){
        return Arrays.stream(values())
                .filter(v -> (v.num == matchCounts))
                .findAny()
                .orElse(null);
    }
}
