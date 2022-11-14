package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
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
        int userMoney = Integer.parseInt(inputView.inputUserMoney());
        int lottoQuantity = LottoQuantityCalculation(userMoney);
        outputView.printQuantity(lottoQuantity);
        userLotto = makeUserLottos(lottoQuantity);
        outputView.printLottoNumber(userLotto);
        WinningLotto winningLotto = inputView.inputLottoNumbers();
        List<Integer> lottoResult = makeResult(winningLotto);

    }

    public List<Integer> makeResult(WinningLotto winningLotto) {
        List<Integer> lottoResult = new ArrayList<>();
        for (int i = 0; i < userLotto.getSize(); i++) {
            lottoResult.add(calculateLotto(userLotto.getLottos(i), winningLotto));
        }
        return lottoResult;
    }

    public int calculateLotto(Lotto lotto, WinningLotto winningLotto) {
        return lotto.compare(winningLotto.getWinningLotto());
    }

    public UserLotto makeUserLottos(int lottoQuantity) {
        UserLotto userLotto = new UserLotto();
        userLotto.setLottos(lottoQuantity);
        return userLotto;
    }

    public int LottoQuantityCalculation(int userMoney) {
        return userMoney / LOTTO_PRICE;
    }
}