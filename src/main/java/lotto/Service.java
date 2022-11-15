package lotto;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Service {
    private Input input;
    private Output output;
    private int price;
    private int startInclusive;
    private int endInclusive;
    private int range;
    private final static String winningNumberMessage="당첨 번호를 입력해 주세요.";
    private final static String bonusNumberMessage="보너스 번호를 입력해 주세요.";
    private final static String cashMessage="구입금액을 입력해 주세요.";


    public Service(int price,int startInclusive,int endInclusive,int range){
        input=new Input(price,startInclusive,endInclusive);
        output=new Output();
        this.price=price;
        this.startInclusive=startInclusive;
        this.endInclusive=endInclusive;
        this.range=range;
        start();
    }
    public void start(){
        int cash=cash();
        int bonusNumber;
        int[] lotteResults;
        List<List<Integer>> lottoBundle=buyLotto(cash/price);
        output.lottoBundlePrint(lottoBundle);
        System.out.println(winningNumberMessage);
        Lotto lotto=new Lotto(input.getWinningNumbers(),range);
        System.out.println(bonusNumberMessage);
        bonusNumber=input.getBonusNumber(lotto.getWinningNumber());
        lotteResults=lotto.lottoResults(lottoBundle,bonusNumber);
        output.winning_stats(lotteResults);
        output.total_money(lotteResults,cash);
    }
    private int cash(){
        System.out.println(cashMessage);
        int lottoCount=input.getCash();
        return lottoCount;
    }
    private List<List<Integer>> buyLotto(int count){
        Buy buy =new Buy(startInclusive,endInclusive,range);
        System.out.println(count+"개를 구매했습니다.");
        return buy.quickPicks(count);
    }
}
