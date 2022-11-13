package lotto.ui;

import java.util.List;
import java.util.Map;
import lotto.model.Rank;

public class ResultView implements View{
    private Map<Rank, Integer> result;
    private float yield;

    ResultView(Map<Rank, Integer> result, float yield){
        this.result = result;
        this.yield = yield;
    }

    @Override
    public void makeView() {
        print();
    }

    private void print(){
        printDefaultMessage();
        printMatches();
        printYield();
    }

    private void printDefaultMessage(){
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    private void printMatches(){
        List<Rank> rankFormat = Rank.rankFormatter();
        for(Rank rank: rankFormat){
            if(rank == Rank.NOT_WINNER){
                continue;
            }
            printEach(rank);
        }
    }

    private void printEach(Rank rank){
        if(rank.isNeedBonus()){
            bonusPrint(rank);
            return;
        }
        System.out.println(
                rank.getMatchedNumber()
                        + "개 일치 (" + rank.getPrice() + ") - "
                        + result.get(rank) +"개"
        );
    }

    private void bonusPrint(Rank rank){
        System.out.println(
                rank.getMatchedNumber()
                        + "개 일치, 보너스 볼 일치 ("
                        + rank.getPrice() + ") - "
                        + result.get(rank) +"개"
        );
    }

    private void printYield(){
        System.out.println("총 수익률은 " + yield + "입니다.");
    }
}
