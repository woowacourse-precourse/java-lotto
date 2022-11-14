package lotto.controller;

import lotto.domain.*;

public class LottoController {
    public void execute(){
        System.out.println("구입금액을 입력해 주세요.");
        Money money = new Money();
        UserLottos userLottos = new UserLottos(money);
        System.out.printf("\n%d개를 구매했습니다.\n", userLottos.getUserLottos().size());

        for (Lotto lotto : userLottos.getUserLottos()){
            System.out.println(lotto.getNumbers());
        }

        System.out.printf("\n당첨 번호를 입력해 주세요.\n");
        PrizeLotto prizeLotto = new PrizeLotto();
        System.out.printf("\n보너스 번호를 입력해 주세요.\n");
        BonusNumber bonusNumber = new BonusNumber(prizeLotto);

        System.out.printf("\n당첨 통계\n---\n");
        CompareNum compareNum = new CompareNum(userLottos, prizeLotto, bonusNumber);
        compareNum.calculateResult();
        int sumProfit = 0;
        for (WinCase winCase : compareNum.getResult().keySet()){
            sumProfit += winCase.getCashPrize() * compareNum.getResult().get(winCase);
            if (winCase.equals(WinCase.FAIL)) continue;
            if (winCase.equals(WinCase.FIVE_WITH_BONUS)){
                System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d\n",winCase.getEqualCount(),winCase.getCashPrize(),compareNum.getResult().get(winCase));
                continue;
            }
            System.out.printf("%d개 일치 (%,d원) - %d\n",winCase.getEqualCount(),winCase.getCashPrize(),compareNum.getResult().get(winCase));
        }
        System.out.printf("총 수익률은 %.1f%% 입니다.", (double) sumProfit / (double) money.getMoney() * 100);
    }
}
