package lotto;

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
        List<List<Integer>> lottoBundle=buyLotto(cash/1000);
        lottoBundlePrint(lottoBundle);
        System.out.println("당첨 번호를 입력해 주세요.");
        Lotto lotto=new Lotto(input.getWinningNumbers());
        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNumber=input.getBonusNumber(lotto.getWinningNumber()); //당첨 번호 중복되는지 확인할 필요있음
        winning_stats();
        yield();
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
        for (List<Integer> lotto: lottoBundle) {
            Collections.sort(lotto);
            System.out.println(lotto);
        }
    }
    private void winning_stats(){

    }
    private void yield(){

    }
}
