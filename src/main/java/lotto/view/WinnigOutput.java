package lotto.view;

import java.util.List;

public enum WinnigOutput {
    FIFTH("5,000" , "3개 일치"),
    FOURTH("50,000" , "4개 일치"),
    THIRD("1,500,000" , "5개 일치"),
    SECOND("30,000,000" , "5개 일치, 보너스 볼 일치"),
    FIRST("2,000,000,000" , "6개 일치");

    private final String money;
    private final String collect;
    WinnigOutput(String money, String collect) {
        this.money = money;
        this.collect = collect;
    }

    public void winningOutput (List<Integer> rank) {
        int i =4;

        System.out.println("당첨 통계");
        System.out.println("---");

        for (WinnigOutput e: WinnigOutput.values()) {
            System.out.println(e.collect+ " ("+e.money+"원) - "+rank.get(i)+"개" );
            i--;
        }
    }
}
