package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import constance.Texts;

import java.util.ArrayList;
import java.util.List;

import static constance.Texts.LOTTO_USER_PURCHASE_RESULT;

public class User {

    private Checker checker;
    private List<Lotto> lotteries;
    private List<List<Result>> results;
    private int lotteryCount;
    private int winnings;

    public User(String input){
        checker=new Checker();

        setAmount(input);
        setLotteries();
    }
    private void setAmount(String input){
        int amount = checker.checkAmountInput(input);
        this.lotteryCount=amount/1000;
    }
    private void setLotteries(){
        this.lotteries=new ArrayList<>();
        for(int i=0;i<lotteryCount;++i){
            lotteries.add(new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6)));
        }
    }
    public String getLotteryList(){
        StringBuffer resultBuffer=new StringBuffer();
        for(Lotto lotto:lotteries){
            resultBuffer.append(lotto+"\n");
        }
        return resultBuffer.toString();
    }

    public int getLotteryCount() {
        return lotteryCount;
    }
}
