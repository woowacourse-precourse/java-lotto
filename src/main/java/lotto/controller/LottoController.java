package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Player;
import lotto.domain.Purchase;
import lotto.domain.Ranking;
import lotto.view.InputView;

public class LottoController {
    private static int ticketNumber;
    private static List<List<Integer>> allPlayerNumbers = new ArrayList<>();
    private static List<Integer> winningNumbers;
    private static int bonusNumber;

    public static void run() {
        // 로또 구입
        Purchase purchase = new Purchase(InputView.inputCash());
        ticketNumber = purchase.get();

        // 로또 발행
        Player player = new Player(ticketNumber);
        allPlayerNumbers = player.get();

        // 당첨 번호 생성
        Lotto lotto = new Lotto(InputView.inputWinningNumbers());
        Bonus bonus = new Bonus(InputView.inputBonusNumber());
        winningNumbers = lotto.get();
        bonusNumber = bonus.get();
        validateDuplicates();

        // 로또 결과 계산
        LottoResult result = new LottoResult(winningNumbers, allPlayerNumbers, bonusNumber);
        List<Integer> matches = result.getMatches();
        List<Boolean> bonusMatches = result.getBonusMatches();

        // 로또 순위 계산
        Ranking ranking = new Ranking(matches, bonusMatches);

        // 당첨 통계 계산

    }

    private static void validateDuplicates() {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");
        }
    }
}
