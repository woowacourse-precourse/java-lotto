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


}
