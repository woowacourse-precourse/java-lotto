package lotto.Domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
public class LotteryMaker{
    // 금액에 따른 로또 개수
    private int lotteryAmount = 0;
    private List<Lotto> lotteryTickets = new ArrayList<Lotto>();
    // getter
    public List<Lotto> getLotteryTickets() {
        return lotteryTickets;
    }
    // 생성자
    public LotteryMaker(){}
    public LotteryMaker(int lotteryAmount){
        this.lotteryAmount = lotteryAmount;
    }

    // 로또의 개수만큼의 로또지 생성
    public void issueLotteryTickets(int lotteryAmount){
        Lotto lotto1 = new Lotto(publishLotteryTicket());
        this.lotteryTickets.add(lotto1);
    }

    // 하나의 로또지 발행
    public List<Integer> publishLotteryTicket(){
        List<Integer> ticket = Randoms.
                pickUniqueNumbersInRange(Constants.firstNumber,
                        Constants.lastNumber, Constants.lotteryLength);
        return ticket;
    }
}
