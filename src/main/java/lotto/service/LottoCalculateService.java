package lotto.service;

import java.util.HashMap;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.User;
import lotto.domain.UserLotto;
import lotto.view.OutputView;

public class LottoCalculateService {
    private static HashMap<Rank, Integer> rankMap = new HashMap<>();
    private static OutputView outputView = new OutputView();

    public void calculateWinningCount(User user, Lotto lotto) {
        List<UserLotto> userLottos = user.getUserLottos();
        for (UserLotto userLotto : userLottos) {
            List<Integer> userLottoEach = userLotto.getLottoNumbers();
            calculateOfLottoAndUserNumber(userLottoEach, lotto);
        }

        outputView.printTotalResultMessage(rankMap);
        outputView.printEarningRateOfLottoMessage(getEarningRate(user));
    }

    public Long getTotalPrice() {
        Long totalPrice = 0L;
        for (Rank rank : rankMap.keySet()) {
            if (rank == Rank.THIRD) {
                int count = rankMap.get(rank);
                totalPrice += (count) * 5000;
                continue;
            }

            if (rank == Rank.FOURTH) {
                int count = rankMap.get(rank);
                totalPrice += (count) * 50000;
                continue;
            }

            if (rank == Rank.FIVE) {
                int count = rankMap.get(rank);
                totalPrice += (count) * 1500000;
                continue;
            }

            if (rank == Rank.FIVE_WITH_BONUS) {
                int count = rankMap.get(rank);
                totalPrice += (count) * 30000000;
                continue;
            }

            if (rank == Rank.SIX) {
                int count = rankMap.get(rank);
                totalPrice += (count) * 2000000000;
            }
        }
        return totalPrice;
    }

    public void calculateOfLottoAndUserNumber(List<Integer> userLottoEach, Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        int bonusNumber = lotto.getBonusNumber();

        int count = 0;
        for (int i = 0; i < userLottoEach.size(); i++) {
            if (lottoNumbers.contains(userLottoEach.get(i))) {
                count++;
            }
        }

        if (count == 6) {
            rankMap.put(Rank.SIX, rankMap.getOrDefault(Rank.SIX, 0) + 1);
        }

        if (count == 5 && userLottoEach.contains(bonusNumber)) {
            rankMap.put(Rank.FIVE_WITH_BONUS, rankMap.getOrDefault(Rank.FIVE_WITH_BONUS, 0) + 1);
        }

        if (count == 5 && !userLottoEach.contains(bonusNumber)) {
            rankMap.put(Rank.FIVE, rankMap.getOrDefault(Rank.FIVE, 0) + 1);
        }

        if (count == 4) {
            rankMap.put(Rank.FOURTH, rankMap.getOrDefault(Rank.FOURTH, 0) + 1);
        }

        if (count == 3) {
            rankMap.put(Rank.THIRD, rankMap.getOrDefault(Rank.THIRD, 0) + 1);
        }
    }
    public String getEarningRate(User user) {
        return String.format("%.1f", ((double) getTotalPrice() / (double) user.getPrice()) * 100);
    }

}
