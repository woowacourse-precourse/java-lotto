package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class LotteryController {
    private final LotteryModel model = new LotteryModel();
    private final LotteryView view = new LotteryView();
    private final RankStatistics statistics = new RankStatistics();

    public LotteryController() {}

    public void purchase() {
        int userInput = Integer.parseInt(view.getUserMoney());
        validateNumIsDivisible(userInput);
        statistics.setUserInput(userInput);

        int purchasedCount = userInput / 1000;
        for (int count = 0; count < purchasedCount; count++) {
            model.generateLottoNumber();
        }
        view.printPurchasedLotto(model.getPurchasedLotto());
    }

    public void setWinningNumber() {
        String userInput = view.getUserNumbers();
        List<Integer> numbers = parseStringToList(userInput);
        validateNumListCount(numbers);
        validateNumListInRange(numbers);
        validateNumListNotDuplicate(numbers);
        model.setWinningNumber(numbers);
    }

    public void setBonusNumber() {
        int userInput = Integer.parseInt(view.getUserBonusNumber());
        validateNumInRange(userInput);
        model.setBonusNumber(userInput);
    }

    public void figureStatistics() {
        Lotto winningNumber = model.getWinningNumber();
        List<Integer> winningNumbers = winningNumber.getNumbers();
        int bonusNumber = model.getBonusNumber();

        List<Lotto> purchasedNumbers = model.getPurchasedLotto();

        for (Lotto number: purchasedNumbers) {
            statistics.addRankData(compare(winningNumber, number, winningNumbers.contains(bonusNumber)));
        }
        view.printStatistics();
        statistics.printStatistics();
    }

    private Rank compare(Lotto winningNumber, Lotto number, Boolean bonusFlag) {
        Map<Integer, Boolean> map = new HashMap<>();
        int matchCount = 0;

        for (int num: winningNumber.getNumbers()) {
            map.put(num, true);
        }

        for (int num: number.getNumbers()) {
            if (map.containsKey(num)) {
                matchCount++;
            }
        }

        return Rank.getRank(matchCount, bonusFlag);
    }

    private List<Integer> parseStringToList(String str) {
       return Arrays.asList(str.split(",")).stream().map(strToken -> Integer.parseInt(strToken)).collect(Collectors.toList());
    }

    private void validateNumIsDivisible(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000으로 나누어 떨어져야 합니다.");
        }
    }

    private void validateNumInRange(int number) {
        if (number >= 1 && number <= 45) return;
        throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    private void validateNumListInRange(List<Integer> numbers) {
        for (int number: numbers) {
            if (number >= 1 && number <= 45) continue;
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateNumListCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개의 숫자로 이루어져야 합니다.");
        }
    }

    private void validateNumListNotDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() < numbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복된 수로 구성될 수 없습니다.");
        }
    }
}
