package lotto.domain.rank;

import java.text.DecimalFormat;

public enum RankInfo {

    OTHERS(0,"순위 밖", 0),
    FIRST(1,"6개 일치 ",2000000000),
    SECOND(2,"5개 일치, 보너스 볼 일치 ", 30000000),
    THIRD(3,"5개 일치 ",1500000),
    FOURTH(4,"4개 일치 ",50000),
    FIFTH(5,"3개 일치 ",5000);

    private final String msg;
    private final int money;

    RankInfo(int rank, String msg,  int money) {
        this.msg = msg;
        this.money = money;
    }

    public String getPriceMsg() {
        DecimalFormat formatter = new DecimalFormat("###,###");
        return "("+formatter.format(this.money)+"원)";
    }

    public String getMsg() {
        return msg;
    }

    public int getMoney() {
        return money;
    }
}
