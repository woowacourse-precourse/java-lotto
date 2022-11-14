package lotto;

import java.util.List;

public class Service {
    Input input;
    public Service(){
        input=new Input();
        start();
    }
    public void start(){
        int cash=cash();
        List<List<Integer>> lottoBundle=buyLotto(cash/1000);
        lottoBundlePrint(lottoBundle); //생성한 로또 번호 출력
        //당첨 번호를 입력해 주세요
        //보너스 번호를 입력해 주세요
        //당첨 통계
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
            System.out.println(lotto);
        }
    }
}
