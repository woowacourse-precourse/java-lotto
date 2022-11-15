package lotto.service;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domian.WinningCriteria.WinningCriteriaInfo;
import lotto.domian.Lotto;
import lotto.domian.UserSingleLottoNumber;
import lotto.domian.User;
import lotto.view.OutputView;
import static lotto.constant.Constant.*;


public class CalculateUserCorrectLottoInfoService {

    private final Map<WinningCriteriaInfo, Integer> countWinning = new HashMap<>();
    OutputView outputView = new OutputView();


    public void countWinningInfo(Lotto lotto, User user) {
        List<UserSingleLottoNumber> userSingleLottoNumbers = user.getUserLottoNumbers();
        userSingleLottoNumbers
          .forEach(userSingleLottoNumber ->
              LottoCompareToWinningNumbers(lotto, userSingleLottoNumber.getLottoNumbers(), user)
          );
    }
    public void LottoCompareToWinningNumbers(Lotto lotto, List<Integer> lottoNumbers, User user){

        int count = compareBonusNumber(lotto.getBonusNumber(), lottoNumbers, compareWinningNumbers(lotto, lottoNumbers));
        WinningCriteriaInfo winning = WinningCriteriaInfo.valueOf(count);
        user.addUserWinningPrice(winning.getPrice());
        countWinning.put(winning, countWinning.getOrDefault(winning, INITIAL_NUMBER) + INCREASE_COUNT_NUMBER);
    }

}
