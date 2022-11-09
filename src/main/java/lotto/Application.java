package lotto;

import static lotto.controller.lottoController.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lotto.view.Output;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Output.printNotice(Notice.start.getNoticeMessage());
        // 로또 얼마나 발행할 건지
        int quantity = checkQuantityOfLotto();

        Output.printResult(quantity, Notice.purchase.getNoticeMessage());

        List<List<Integer>> candidate = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            Lotto lotto = new Lotto(pickLottoNumbers());
            publishLotto(candidate, lotto.getNumbers());
            System.out.println(candidate.get(i));
        }

        //당첨 번호 입력
        Lotto lotto = new Lotto(pickWinningNumbers());
        int bonusNumber = pickBonusNumbers();

        Output.printNotice(Notice.statistics.getNoticeMessage());

        List<String> msg = Arrays.asList("3개 일치 (5,000원)", "4개 일치 (50,000원)", "5개 일치 (1,500,000원)", "5개 일치, 보너스 볼 일치 (30,000,000원)",
                "6개 일치 (2,000,000,000원)");

        List<Integer> count = countWinningLotto(candidate, lotto.getNumbers(), bonusNumber, quantity);

        for (int i = 0; i < count.size(); i++) {
            System.out.println(msg.get(i) + " - " + count.get(i) + "개");
        }
        System.out.println("총 수익률은 " + calculateProfit(count, quantity * 1000) + "%입니다.");
    }
}
