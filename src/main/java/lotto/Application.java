package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.Constants.*;

public class Application {

    public static void main(String[] args) {
        String purchaseAmount = InputView.getPurchaseAmount();

        int lottoCount = OutputView.getLottoCount(purchaseAmount, UNIT);
        List<Lotto> userLotto = publishLotto(lottoCount);
        OutputView.showLottoSheets(userLotto);

        List<Integer> winningNumbers = InputView.getWinningNumber();
        String bonusNumber = InputView.getBonusNumber();
    }

    private static List<Lotto> publishLotto(int lottoCount) {
        List<Lotto> userLotto = new ArrayList<>();
        for (int count = 0; count < lottoCount; count++) {
            userLotto.add(createLotto());
        }
        return userLotto;
    }

    private static Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUM, END_NUM, COUNT_NUM);
        Collections.sort(numbers);
        Lotto lotto = new Lotto(numbers);
        return lotto;
    }

    public static Map<RankEnum, Integer> calculateWinning(List<Lotto> lottoTickets,
            List<Integer> winningNumbers, String bonusNumber) {
        Map<RankEnum, Integer> winningHistory = initWinningHistory();
        for (int count = 0; count < lottoTickets.size(); count++) {
            int match = matchCount(lottoTickets.get(count), winningNumbers);
            boolean isBonus = matchBonus(lottoTickets.get(count), bonusNumber);
            RankEnum rank = RankEnum.getRanking(match, isBonus);
            winningHistory.put(rank, winningHistory.get(rank) + 1);
        }
        return winningHistory;
    }

    private static Map<RankEnum, Integer> initWinningHistory() {
        Map<RankEnum, Integer> winningHistory = new HashMap<>();
        Arrays.stream(RankEnum.values())
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
}
