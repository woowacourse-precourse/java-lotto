package lotto;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private static int money;
    private static int pages;
    private static List<Lotto> userLotto;
    private static List<Integer> winningNumber;
    private static int bonus;
    private static int profit = 0;


    public void buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        this.money = LottoBuyer.getInstance.getPay();


        pages = LottoSeller.getInstance.getSellPages(money);
        System.out.println("\n" + pages + "개를 구매했습니다.");

        this.userLotto = LottoGenerator.getInstance.issueLotto(pages);
        userLotto.stream()
                .forEach(user -> System.out.println(user.getLotto()));
    }

    public void determiningWinningNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요.");

        this.winningNumber = LottoDesignator.getInstance.inputLotto();

        System.out.println("\n보너스 번호를 입력해 주세요.");

        this.bonus = LottoDesignator.getInstance.inputBonus();
    }

    public void judgeLottoNumber() {
        for(Lotto userLotto: userLotto) {
            LottoResultJudge.getInstance.judgeLotto(userLotto.getLotto(), winningNumber, bonus);
        }
    }


    public void statsLotto() {
        System.out.println("\n당첨통계\n---");
        System.out.println(LottoResult.FIFTH.getName() + LottoResult.FIFTH.getCount() + "개");
        System.out.println(LottoResult.FOURTH.getName() + LottoResult.FOURTH.getCount() + "개");
        System.out.println(LottoResult.THIRD.getName() + LottoResult.THIRD.getCount() + "개");
        System.out.println(LottoResult.SECOND.getName() + LottoResult.SECOND.getCount() + "개");
        System.out.println(LottoResult.FIRST.getName() + LottoResult.FIRST.getCount() + "개");

        for(LottoResult lottoResult: LottoResult.values()) {
            profit += lottoResult.getProfit();
        }

        System.out.println("총 수익률은 " + ProfitCalculator.getInstance.profitPercent(money, profit) + "%입니다.");
    }
}
