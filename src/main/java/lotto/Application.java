package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import constants.Rank;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        LottoMachine lottoMachine = new LottoMachine();

        int money = InputService.moneyInput();

        List<Lotto> lottos = lottoMachine.buyLotto(money);

        lottoMachine.printLottosInfo(lottos);

        Integer[] integers = InputService.winningNumberInput();

        System.out.println();
        Integer bonusNumber = InputService.bonusNumberInput();

        LottoRaffler raffler = new LottoRaffler(integers,bonusNumber);

        List<Rank> raffle = raffler.raffle(lottos);

        LottoResultManager resultManager = new LottoResultManager();
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+resultManager.getResult(raffle, Rank.THREE)+"개");
        System.out.println("4개 일치 (50,000원) - "+resultManager.getResult(raffle, Rank.FOUR)+"개");
        System.out.println("5개 일치 (1,500,000원) - "+resultManager.getResult(raffle, Rank.FIVE)+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+resultManager.getResult(raffle, Rank.BONUS)+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+resultManager.getResult(raffle, Rank.SIX)+"개");

        double reward = resultManager.getReward();
        double v = (reward / money) * 100;

        System.out.println("총 수익률은 "+String.format("%.1f",v)+"%입니다.");

    }




}
