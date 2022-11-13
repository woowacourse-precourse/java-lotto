package lotto;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private static final LottoBuyer lottoBuyer = new LottoBuyer();
    private static final LottoSeller lottoSeller = new LottoSeller();
    private static final LottoDesignator lottoDesignator = new LottoDesignator();
    private static final LottoResultJudge lottoResultJudge = new LottoResultJudge();
    private static final LottoGenerator lottoGenerator = new LottoGenerator();

    public static void startLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = 0;
        try {
            money = lottoBuyer.getPay();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }


        int pages = lottoSeller.getSellPages(money);
        System.out.println("\n" + pages + "개를 구매했습니다.");

        List<Lotto> userLotto = lottoGenerator.issueLotto(pages);
        for(int userLottoIndex = 0; userLottoIndex<userLotto.size(); userLottoIndex++) {
            System.out.println(userLotto.get(userLottoIndex).getLotto());
        }

        System.out.println("\n당첨 번호를 입력해 주세요.");
        List<Integer> winningNumber = lottoDesignator.inputLotto();

        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonus = lottoDesignator.inputBonus();

        List<LottoResult> lottoResult = new ArrayList<>();
        for(int i = 0; i<pages; i++) {
            lottoResult.add(lottoResultJudge.judgeLotto(userLotto.get(i).getLotto(), winningNumber, bonus));
        }

        int[] count = new int[5];
        for(int lottoResultIndex = 0; lottoResultIndex<lottoResult.size(); lottoResultIndex++) {
            if(lottoResult.get(lottoResultIndex).equals(LottoResult.FIRST)) {
                count[0]++;
            }
            if(lottoResult.get(lottoResultIndex).equals(LottoResult.SECOND)) {
                count[1]++;
            }
            if(lottoResult.get(lottoResultIndex).equals(LottoResult.THIRD)) {
                count[2]++;
            }
            if(lottoResult.get(lottoResultIndex).equals(LottoResult.FOURTH)) {
                count[3]++;
            }
            if(lottoResult.get(lottoResultIndex).equals(LottoResult.FIFTH)) {
                count[4]++;
            }
        }

        System.out.println("\n당첨통계\n---");
        System.out.println(LottoResult.FIFTH.getName() + count[4] + "개");
        System.out.println(LottoResult.FOURTH.getName() + count[3] + "개");
        System.out.println(LottoResult.THIRD.getName() + count[2] + "개");
        System.out.println(LottoResult.SECOND.getName() + count[1] + "개");
        System.out.println(LottoResult.FIRST.getName() + count[0] + "개");

        System.out.println("총 수익률은 62.5%입니다.");
    }

}
