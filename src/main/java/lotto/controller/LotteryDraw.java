package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.LottoGenerator;
import lotto.service.UserBonusNumberService;
import lotto.service.UserLottoNumberService;
import lotto.service.UserMoneyService;
import lotto.utils.Rank;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LotteryDraw {

    UserMoneyService userMoney = new UserMoneyService();
    UserLottoNumberService userLottoNumber = new UserLottoNumberService();
    UserBonusNumberService userBonusNumber = new UserBonusNumberService();
    LottoGenerator lottoGenerator = new LottoGenerator();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Rank rank;

    int Money = userMoney.getUserMoney();
    int lottoCount = Money / 10;
    List<Lotto> autoLotto = lottoGenerator.AutoCreateLotto(lottoCount);
    List<Integer> winLottoNumber = userLottoNumber.getLottoNumber();
    int bonusNumber = userBonusNumber.getBonusNumber();

    public void lotto() {
        inputView.printUserInputMoney(Money);
        outputView.printLottoCount(lottoCount);
        outputView.printAutoCreateLotto(autoLotto);
        inputView.printUserInputLottoNumber(winLottoNumber);
        inputView.printUserInputBonusNumber(bonusNumber);
        outputView.printLottoResult(TotalCountMap());
        int winningMoney = rank.winnings(TotalCountMap());
        outputView.printProfitResult(winningMoney, Money);
    }

    public Map<Rank, Integer> TotalCountMap() {
        Map<Rank, Integer> countMap = new EnumMap<>(Rank.class);
        for (Lotto lotto : autoLotto) {
            int digit = count(lotto);
            countMap = TotalMap(countMap,digit);
        }
        return countMap;
    }

    public int count(Lotto lotto) {
        int count = 0;
        for (int i = 0; i < winLottoNumber.size(); i++) {
            if (winLottoNumber.contains(lotto.getAutoNumbers().get(i))) {
                count++;
            }
        }
        return count;
    }

    public Map<Rank, Integer> TotalMap(Map<Rank, Integer> map, int count) {
        if (count == 3) {
            map.put(Rank.CATCH_THREE_NUMBER, map.get(Rank.CATCH_THREE_NUMBER) + 1);
        }
        if (count == 4) {
            map.put(Rank.CATCH_FOUR_NUMBER, map.get(Rank.CATCH_FOUR_NUMBER) + 1);
        }
        if (count == 5 && userBonusNumber.isBonusNumberSameLottoNumber()) {
            map.put(Rank.CATCH_FIVE_AND_BONUS_NUMBER, map.get(Rank.CATCH_FIVE_AND_BONUS_NUMBER) + 1);
        }
        if (count == 5 && !userBonusNumber.isBonusNumberSameLottoNumber()) {
            map.put(Rank.CATCH_FIVE_NUMBER, map.get(Rank.CATCH_FIVE_NUMBER) + 1);
        }
        if (count == 6) {
            map.put(Rank.CONGRATULATIONS, map.get(Rank.CONGRATULATIONS) + 1);
        }
        return map;
    }
}