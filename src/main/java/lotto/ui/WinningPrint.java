package lotto.ui;
import lotto.domain.Winning;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class WinningPrint {
    public WinningPrint(int[] arrCount) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        System.out.println("\n당첨 통계");
        System.out.println("---");
        for (Winning info: Winning.values()){
            int index=info.ordinal();   // index return
            System.out.println(info.getMsg()+" ("+formatter.format(info.getPrice())+"원) - "+arrCount[index]+"개\n");
        }
    }
}
