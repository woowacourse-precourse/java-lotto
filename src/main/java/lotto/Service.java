package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Service {
    Input input;
    public Service(){
        input=new Input();
        start();
    }
    public void start(){
        int cash=cash();
        int bonusNumber;
        int[] lotteResults;
        List<List<Integer>> lottoBundle=buyLotto(cash/1000);
        lottoBundlePrint(lottoBundle);
        System.out.println("당첨 번호를 입력해 주세요.");
        Lotto lotto=new Lotto(input.getWinningNumbers());
        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNumber=input.getBonusNumber(lotto.getWinningNumber());
        lotteResults=lotto.lotteResults(lottoBundle,bonusNumber);
        winning_stats(lotteResults);
        total_money(lotteResults,cash);
    }
    private int cash(){
        System.out.println("구입금액을 입력해 주세요.");
        int lottoCount=input.getCash();
        return lottoCount;
    }
    private List<List<Integer>> buyLotto(int count){
        Buy buy =new Buy();
        System.out.println(count+"개를 구매했습니다.");
        return buy.quickPicks(count);
    }
    private void lottoBundlePrint(List<List<Integer>> lottoBundle){
        List<Integer> currentLotto;
        for (List<Integer> lotto: lottoBundle) {
            currentLotto=new ArrayList<>(lotto);
            Collections.sort(currentLotto);
            System.out.println(currentLotto);
        }
    }
    private void winning_stats(int[] lotteResults){
        System.out.println("당첨 통계");
        System.out.println("---");
        int order=0;
        for(Result result :Result.values()){
            System.out.println(result.getWin()+lotteResults[order]+"개");
            order++;
        }
    }
    private void total_money(int[] lotteResults,int cash){
        double money=0;
        int order=0;
        for(Result result : Result.values()){
            money=money+lotteResults[order]*result.getReward();
            order++;
        }
        double moneyRate=money/cash*100;
        moneyRate = Math.round(moneyRate * 100) / 100.0;
        System.out.println("총 수익률은 "+moneyRate+"%입니다.");
    }
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
}
