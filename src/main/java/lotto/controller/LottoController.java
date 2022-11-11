package lotto.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Player;
import lotto.model.Purchase;
import lotto.view.InputView;

public class LottoController {
    public static void run() {
        Purchase issueCount = new Purchase(InputView.inputCash());
        List<List<Integer>> playerLotto = new ArrayList<>();

        for (int i = 0; i < issueCount.get(); i++) {
            Player player = new Player();
            List<Integer> playerNumbers = new ArrayList<>(player.get());
            Collections.sort(playerNumbers);
            playerLotto.add(playerNumbers);
            System.out.println(playerNumbers);
        }

        Lotto lotto = new Lotto(InputView.inputWinningNumbers());
        Bonus bonusNumber = new Bonus(InputView.inputBonusNumber());

        if (lotto.get().contains(bonusNumber.get())) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");
        }

        List<Integer> countResults = new ArrayList<>();
        List<Integer> bonusResults = new ArrayList<>();
        for (List<Integer> playerNumbers : playerLotto) {
            LottoResult result = new LottoResult(lotto.get(), playerNumbers, bonusNumber.get());
            countResults.add(result.getCountSame());
            bonusResults.add(result.getBonusSame());
        }
        int three = Collections.frequency(countResults, 3);
        int four = Collections.frequency(countResults, 4);
        int five = Collections.frequency(countResults, 5);
        int fiveBonus = Collections.frequency(bonusResults,1);
        int six = Collections.frequency(countResults, 6);

        System.out.println("3개 일치 (5,000원) - " + three + "개");
        System.out.println("4개 일치 (50,000원) - " + four + "개");
        System.out.println("5개 일치 (1,500,000원) - " + five + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + fiveBonus + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + six + "개");
    }
}
