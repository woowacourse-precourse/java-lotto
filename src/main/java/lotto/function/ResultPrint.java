package lotto.function;

import java.util.HashMap;
import java.text.NumberFormat;

public class ResultPrint {
    HashMap<Integer, Integer> lottoRate;
    int lottoNumber;
    public ResultPrint(HashMap<Integer, Integer> lotto, int number){
        this.lottoRate = lotto;
        this.lottoNumber = number;
    }

    public void printRate(){
        for (RankEnum rank : RankEnum.values()){
            System.out.println(rank.message() + " - " + lottoRate.get(rank.value()) +"개");
        }
    }

    public void totalProfit(){
        int total_money = 0;
        for (RankEnum rank : RankEnum.values()){
            total_money += rank.money() * lottoRate.get(rank.value());
        }

        System.out.println("총 수익률은 " + Math.round(total_money/lottoNumber)/10.0 + "%입니다.");
    }
}
