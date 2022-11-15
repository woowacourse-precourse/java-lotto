package lotto;

import java.util.List;

public class output {
    static void outputResult(List<Integer> count_rank){
        String output;
        int index;
        int count;

        System.out.println("당첨 통계");
        System.out.println("---");

        for(RankSystem.RankType r : RankSystem.RankType.values()){
            output = r.getResult();
            index = r.getIndex();
            count = count_rank.get(index);
            System.out.print(output + " - " + count +"개\n");
        }
    }
    static void ownPrice(int price,int money){
        float result = ((float)price /(float)money) * 100;
        System.out.println("총 수익률은 " + String.format("%.1f",result) + "%입니다.\n");
    }
}