package lotto;

import static lotto.controller.lottoController.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("구입 금액을 입력해 주세요");
        // 로또 얼마나 발행할 건지
        int quantity = checkQuantityOfLotto();

        System.out.println(quantity + "개를 구매했습니다");

        List<List<Integer>> candidate = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            publishLotto(candidate,pickLottoNumbers());
            System.out.println(candidate.get(i));
        }

        //당첨 번호 입력
        List<Integer> winningNumbers = pickWinningNumbers();
        int bonusNumber = pickBonusNumbers();


        System.out.println("당첨 통계");
        System.out.println("---");

        List<String> msg = Arrays.asList("3개 일치 (5,000원)", "4개 일치 (50,000원)", "5개 일치 (1,500,000원)", "5개 일치, 보너스 볼 일치 (30,000,000원)",
                "6개 일치 (2,000,000,000원)");

        List<Integer> count = countWinningLotto(candidate, winningNumbers, bonusNumber, quantity);

        for (int i = 0; i < count.size(); i++) {
            System.out.println(msg.get(i) + " - " + count.get(i) + "개");
        }
        System.out.println("총 수익률은 " + calculateProfit(count, quantity * 1000) + "%입니다");
    }
}
