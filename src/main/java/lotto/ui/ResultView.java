package lotto.ui;

import java.util.List;

public class ResultView implements View{
    private List<Integer> result;

    ResultView(List<Integer> result){
        this.result = result;
    }

    @Override
    public void makeView() {

    }

    private void printDefaultMessage(){
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    private void print3Matches(){
        System.out.println("3개 일치 (5,000원) - "+ result.get(0) +"개");
    }

    private void print4Matches(){
        System.out.println("4개 일치 (50,000원) - " + result.get(1) + "개");
    }
    private void print5Matches(){
        System.out.print("5개 일치 (1,500,000원) - " + result.get(2) + "개");
    }
    private void print5AndBonusMatches(){
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.get(3) + "개");
    }

}
