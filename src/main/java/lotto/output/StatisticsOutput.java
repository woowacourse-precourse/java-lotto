package lotto.output;

import java.util.List;

public class StatisticsOutput {
    public void outputWiningHistory(List<Integer> winingHistory){
        StringBuilder output = new StringBuilder("당첨통계\n");
        output.append("---\n");
        output.append("3개 일치 (5,000원) - "+winingHistory.get(0)+"개\n");
        output.append("4개 일치 (50,000원) - "+winingHistory.get(1)+"개\n");
        output.append("5개 일치 (1,500,000원) - "+winingHistory.get(2)+"개\n");
        output.append("5개 일치, 보너스 볼 일치 (30,000,000원) - "+winingHistory.get(4)+"개\n");
        output.append("6개 일치 (2,000,000,000원) - "+winingHistory.get(3)+"개\n");
        System.out.print(output);
    }
    public void outputProfit(double profit){
        System.out.println("총 수익률은 "+profit+"%입니다.");
    }
}
