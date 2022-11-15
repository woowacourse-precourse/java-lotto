package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.View.InputView;
import lotto.View.OutputView;

import static lotto.Constants.*;

public class Application {

    public static void main(String[] args) {
        String purchaseAmount = InputView.getPurchaseAmount();

        int lottoCount = OutputView.getLottoCount(purchaseAmount, UNIT);
        List<Lotto> lottoTickets = publishLotto(lottoCount);
        OutputView.showLottoSheets(lottoTickets);

        List<Integer> winningNumbers = InputView.getWinningNumber();
        String bonusNumber = InputView.getBonusNumber(winningNumbers);
        Map<Rank, Integer> winningHistory
                = calculateWinning(lottoTickets, winningNumbers, bonusNumber);
        OutputView.showWinningHistory(winningHistory);
        double rateReturn = getRateOfReturn(purchaseAmount, winningHistory);
        OutputView.showRateOfReturn(rateReturn);
    }

    private static List<Lotto> publishLotto(int lottoCount) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int count = 0; count < lottoCount; count++) {
            lottoTickets.add(createLotto());
        }
        return lottoTickets;
    }

    private static Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUM, END_NUM, COUNT_NUM);
        List<Integer> sortedNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            sortedNumbers.add(number);
        }
        Collections.sort(sortedNumbers);
        Lotto lotto = new Lotto(sortedNumbers);
        return lotto;
    }

    public static Map<Rank, Integer> calculateWinning(List<Lotto> lottoTickets,
            List<Integer> winningNumbers, String bonusNumber) {
        Map<Rank, Integer> winningHistory = initWinningHistory();
        for (int count = 0; count < lottoTickets.size(); count++) {
            int match = matchCount(lottoTickets.get(count), winningNumbers);
            boolean isBonus = matchBonus(lottoTickets.get(count), bonusNumber);
            Rank rank = Rank.getRanking(match, isBonus);
            winningHistory.put(rank, winningHistory.get(rank) + 1);
        }
        return winningHistory;
    }

    private static Map<Rank, Integer> initWinningHistory() {
        Map<Rank, Integer> winningHistory = new HashMap<>();
        Arrays.stream(Rank.values())
                .map(history -> winningHistory.put(history, 0)).collect(Collectors.toList());
        return winningHistory;
    }

    public static int matchCount(Lotto lotto, List<Integer> winningNumbers) {
        int match = 0;
        for (int number : winningNumbers) {
            if (lotto.getNumbers().contains(number)) {
                match++;
            }
        }
        return match;
    }

    public static boolean matchBonus(Lotto lotto, String bonus) {
        int bonusNumber = Integer.parseInt(bonus);
        if (lotto.getNumbers().contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    private static double getRateOfReturn(String purchaseAmount,
            Map<Rank, Integer> winningHistory) {
        double winningAmount = 0;
        for (Rank rank : Rank.values()) {
            winningAmount += winningHistory.get(rank) * rank.getPrize();
        }
        double rateReturn = (winningAmount / Integer.parseInt(purchaseAmount)) * 100;
        return Math.round(rateReturn * 100) / 100.0;
    }
}
