package lotto.Domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
public class LottoMaker {
    // 금액에 따른 로또 개수
    private int lotteryAmount = 0;
    private List<Lotto> lotteryTickets = new ArrayList<Lotto>();
    // getter
    public List<Lotto> getLotteryTickets() {
        return lotteryTickets;
    }
    // 생성자
    public LottoMaker(){}
    public LottoMaker(int lotteryAmount){
        this.lotteryAmount = lotteryAmount;
    }

    // 생성된 로또지 출력
    public void printLotteryTickets(){
        System.out.println("8개를 구매했습니다.");
        for(Lotto lottery:lotteryTickets){
            System.out.println(lottery);
        }
    }

    // 로또의 개수만큼의 로또지 생성
    public void issueLotteryTickets(int lotteryAmount){
        Lotto lotto = new Lotto(publishLotteryTicket());
        this.lotteryTickets.add(lotto);
    }

    // 하나의 로또지 발행
    public List<Integer> publishLotteryTicket(){
        List<Integer> ticket = Randoms.
                pickUniqueNumbersInRange(Constants.firstNumber,
                        Constants.lastNumber, Constants.lotteryLength);
        return ticket;
    }
}
