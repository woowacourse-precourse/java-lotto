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

    public User(){
        checker=new Checker();
        System.out.println(Texts.LOTTO_USER_INPUT_PURCHASE_AMOUNT);
        setAmount();
        setLotteries();
        System.out.println(String.format(LOTTO_USER_PURCHASE_RESULT,lotteryCount,getLotteryList()));
    }
    private void setAmount(){
        String input = camp.nextstep.edu.missionutils.Console.readLine();
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

}
