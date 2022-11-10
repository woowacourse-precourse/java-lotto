package lotto;

import static lotto.LottoPrize.FIFTH_PRIZE;
import static lotto.LottoPrize.FIRST_PRIZE;
import static lotto.LottoPrize.FOURTH_PRIZE;
import static lotto.LottoPrize.SECOND_PRIZE;
import static lotto.LottoPrize.THIRD_PRIZE;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {

        LottoVendor lottoVendor=new LottoVendor();
        Buyer buyer=new Buyer();
        // 구입 금액을 입력하여, 로또를 구입한다.
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseMoney=Integer.parseInt(Console.readLine());
        buyer.purchase(lottoVendor,purchaseMoney);//특정가게에서 금액/1000개의 로또를 구입한다.

        System.out.println("\n"+buyer.getLottoTicketAmount()+"개를 구매했습니다.");
        for(Lotto lotto:buyer.getHoldingLottoTickets()){
            System.out.println(lotto.getNumbers());
        }

        // 추첨을 진행한다.
        System.out.println("\n당첨 번호를 입력해 주세요.");
        List<Integer> winningNumber= Arrays.stream(Console.readLine().split(","))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        Lotto winningLotto=new Lotto(winningNumber);
        System.out.println("\n보너스 번호를 입력해주세요");
        int bonusNumber=Integer.parseInt(Console.readLine());
        LotteryMachine lotteryMachine=new LotteryMachine(winningLotto,bonusNumber);

        // 결과 분석 의뢰
        LottoReferee lottoReferee=new LottoReferee();
        Map<LottoPrize,Integer> result=lottoReferee.analyzeResult(lotteryMachine,buyer);

        // 당첨 통계 확인
        System.out.println("\n당첨 통계\n---");
        for(LottoPrize prize:List.of(FIFTH_PRIZE,FOURTH_PRIZE,THIRD_PRIZE,SECOND_PRIZE,FIRST_PRIZE)) {
            System.out.println(prize.ofDescription() + " - " + result.get(prize) + "개");
        }
        // 수익률 확인
        System.out.printf("총 수익률은 %.1f%%입니다.",(float)lottoReferee.sumPrizes()/buyer.countHoldingLotto()*1000*100);

    }
}
