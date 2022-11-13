package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
public class LotteryMaker{
    private int lotteryAmount = 0;
    private List<Lotto> lotteryTickets;
    public LotteryMaker(int lotteryAmount){
        this.lotteryAmount = lotteryAmount;
    }

    public void getLotteryTickets(){
    }
    public void publishLotteryTickets(){
        List<Integer> l = Randoms.
                pickUniqueNumbersInRange(Constants.firstNumber,
                        Constants.lastNumber, Constants.lotteryLength);
    }
}
