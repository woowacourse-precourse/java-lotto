package lotto.enums;

import java.math.BigDecimal;

public enum LottoRanking {
    FIFTH("3개 일치 (5,000원) - ", 0, 5000),
    FOURTH("4개 일치 (50,000원) - ", 0, 50000),
    THIRD("5개 일치 (1,500,000원) - ", 0, 1500000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 0, 30000000),
    FIRST("6개 일치 (2,000,000,000원) - ", 0, 2000000000);
    private String winningPhrase;
    public Integer count;
    public Integer prizeMoney;

    LottoRanking(String winningPhrase, Integer count, Integer prizeMoney) {
        this.winningPhrase = winningPhrase;
        this.count = count;
        this.prizeMoney = prizeMoney;
    }

    public String getValue() {
        return winningPhrase + count + "개";
    }


    public static void main(String[] args) {


        System.out.print("SSSS");


    }
}
