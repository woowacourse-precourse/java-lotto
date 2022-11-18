package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRanking;
import lotto.domain.UserLotto;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoSystem {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final int LOTTO_PRICE = 1000;
    private static UserLotto userLotto;

    public void startLottoSystem() {
        try {
            int userMoney = Integer.parseInt(inputView.inputUserMoney());
            int lottoQuantity = calculationLottoQuantity(userMoney);
            outputView.printQuantity(lottoQuantity);

            userLotto = makeUserLottos(lottoQuantity);
            outputView.printLottoNumber(userLotto);

            WinningLotto winningLotto = inputView.inputLottoNumbers();
            List<LottoRanking> lottoResult = makeResult(winningLotto);
            outputView.printLottoResult(lottoResult);

            int prizeMoney = calculatePrizeMoney(lottoResult);
            outputView.printYield(calculateYield(prizeMoney, userMoney));
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
        }
    }

    public double calculateYield(int prizeMoney, int userMoney) {
        if(prizeMoney == 0) {
            return 0;
        }
        return (((double) prizeMoney / (double) userMoney) * 100.0);
    }

    public int calculatePrizeMoney(List<LottoRanking> lottoResult) {
        int prizeMoney = 0;
        for(LottoRanking ranking : lottoResult) {
            prizeMoney += ranking.getPrizeMoney();
        }
        return prizeMoney;
    }

    public List<LottoRanking> makeResult(WinningLotto winningLotto) {
        List<LottoRanking> lottoResult = new ArrayList<>();
        for (int index = 0; index < userLotto.getSize(); index++) {
            int countNumber = calculateLotto(userLotto.getLottos(index), winningLotto);
            if(countNumber == 5) {
                lottoResult.add(addBonusResult(index, winningLotto.getBonusNumber()));
                continue;
            }
            lottoResult.add(LottoRanking.getByindex(countNumber));
        }
        return lottoResult;
    }

    public int calculateLotto(Lotto lotto, WinningLotto winningLotto) {
        return lotto.compare(winningLotto.getWinningLotto());
    }

    private LottoRanking addBonusResult(int index, int bonusNumber) {
        if(userLotto.getLottos(index).getNumbers().contains(bonusNumber)) {
            return LottoRanking.FIVE_AND_BONUS_RIGHT;
        }
        return LottoRanking.FIVE_RIGHT;
    }

    public UserLotto makeUserLottos(int lottoQuantity) {
        UserLotto userLotto = new UserLotto();
        userLotto.setLottos(lottoQuantity);
        return userLotto;
    }

    public int calculationLottoQuantity(int userMoney) {
        return userMoney / LOTTO_PRICE;
    }
}