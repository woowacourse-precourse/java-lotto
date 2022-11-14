package lotto;

import java.util.List;

public class ShowResult {
    static void write_result(List<Integer> count_rank){
        String output_temp;
        int index_temp;
        int count_temp;

        System.out.println("당첨 통계");
        System.out.println("---");

        for(LottoRank.RankType r : LottoRank.RankType.values()){
            output_temp = r.getResult();
            index_temp = r.getCheck();
            count_temp = count_rank.get(index_temp);
            System.out.print(output_temp + " - " + count_temp +"개\n");
        }
    }
    static void calculate_price(int price,int money){
        float result = ((float)price /(float)money) * 100;
        System.out.println("총 수익률은 " + String.format("%.1f",result) + "%입니다.\n");
    }
}
