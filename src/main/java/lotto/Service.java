package lotto;

public class Service {
    Input input;
    public Service(){
        input=new Input();
        start();
    }
    public void start(){
        //구입금액을 입력해 주세요
        //를 구매했습니다.
        int cash=buyLotto();
        //당첨 번호를 입력해 주세요
        //보너스 번호를 입력해 주세요
        //당첨 통계
    }
    private int buyLotto(){
        System.out.println("구입금액을 입력해 주세요.");
        int lottoCount=input.enterCash();
        System.out.println(lottoCount+"개를 구매했습니다.");
        return lottoCount;
    }
}
