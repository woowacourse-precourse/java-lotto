package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.ENUMS.LotteryRules;

import java.util.ArrayList;
import java.util.List;

public class LotteryDrawMachine {
    public final static int ea = 1000;
    User user;
    List<Lotto> lottos;
    UIManager ui = new UIManager();
    int numOfPurchasableLotto;
    WinningNumber wn;
    LotteryScratch lotteryScratch;

    public LotteryDrawMachine() {
        user = new User(ui.enterPurchaseAmount());
        lottos = generateLotto();
        ui.buyLottos(numOfPurchasableLotto, lottos);
        String winningNumber = ui.enterWinningNumber();
        String bonusNumber = ui.enterBonusNumber();
        wn = new WinningNumber(winningNumber, bonusNumber);
        lotteryScratch = new LotteryScratch(wn, lottos, user);
        ui.winningStat(user);
    }

    // 유저 금액만큼 로또 생성
    public List<Lotto> generateLotto() {
        lottos = new ArrayList<>();
        numOfPurchasableLotto = user.getPurchaseAmount() / ea;

        for (int i = 0; i < numOfPurchasableLotto; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LotteryRules.START_INCLUSIVE.getNumber(),
                    LotteryRules.END_INCLUSIVE.getNumber(), LotteryRules.COUNT.getNumber());
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    public User getUser() {
        return user;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
