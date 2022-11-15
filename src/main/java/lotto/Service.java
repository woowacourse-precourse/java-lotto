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
        bonusNumber=input.getBonusNumber(lotto.getWinningNumber()); //당첨 번호 중복되는지 확인할 필요있음
        lotteResults=lotto.lotteResults(lottoBundle,bonusNumber);
        winning_stats(lotteResults);
        total_money(lotteResults,cash);
    }
    private int cash(){//이름 변경
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
        System.out.println("3개 일치 (5,000원) - "+lotteResults[0]+"개");
        System.out.println("4개 일치 (50,000원) - "+lotteResults[1]+"개");
        System.out.println("5개 일치 (1,500,000원) - "+lotteResults[2]+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+lotteResults[3]+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+lotteResults[4]+"개");
    }
    private void total_money(int[] lotteResults,int cash){
        double money=lotteResults[0]*5000;
        money=money+lotteResults[1]*50000;
        money=money+lotteResults[2]*1500000;
        money=money+lotteResults[3]*30000000;
        money=money+lotteResults[4]*2000000000;
        double moneyRate=money/cash*100;
        moneyRate = Math.round(moneyRate * 100) / 100.0;
        System.out.println("총 수익률은 "+moneyRate+"%입니다.");
    }
}
