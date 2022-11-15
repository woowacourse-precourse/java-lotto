package lotto;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Output {
    private final static String totalMessage="당첨 통계\n---";
    public enum Result{
        FIFTH("3개 일치 (5,000원) - ",5000),
        FOURTH("4개 일치 (50,000원) - ",50000),
        THIRD("5개 일치 (1,500,000원) - ",1500000),
        SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - ",30000000),
        FIRST("6개 일치 (2,000,000,000원) - ",2000000000);
        private final String win;
        private final int reward;
        Result(String win, int reward) {
            this.win=win;
            this.reward=reward;
        }
        public String getWin(){
            return win;
        }
        public int  getReward(){
            return reward;
        }
    }

    public void lottoBundlePrint(List<List<Integer>> lottoBundle){
        List<Integer> currentLotto;
        for (List<Integer> lotto: lottoBundle) {
            currentLotto=new ArrayList<>(lotto);
            Collections.sort(currentLotto);
            System.out.println(currentLotto);
        }
    }
    public void winning_stats(int[] lotteResults){
        System.out.println(totalMessage);
        int order=0;
        for(Result result :Result.values()){
            System.out.println(result.getWin()+lotteResults[order]+"개");
            order++;
        }
    }
    public void total_money(int[] lotteResults,int cash){
        double money=0;
        int order=0;
        for(Result result : Result.values()){
            money=money+lotteResults[order]*result.getReward();
            order++;
        }
        double moneyRate=money/cash*100;
        moneyRate = Math.round(moneyRate * 100) / 100.0;
        NumberFormat numberFormat =NumberFormat.getInstance();
        numberFormat.setGroupingUsed(false);
        System.out.println("총 수익률은 "+numberFormat.format(moneyRate)+"%입니다.");
    }
}
