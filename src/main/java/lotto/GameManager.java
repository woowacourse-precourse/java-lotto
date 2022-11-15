package lotto;

import lotto.utils.View;
import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.enums.LottoCondition.*;
import static lotto.utils.Input.*;

public class GameManager {

    public GameManager() {
    }

    public void run() {
        Long price = askPrice();
        List<Lotto> publishedLottos = publishLottosFromPrice(price);
        Lotto winningLotto = askWinningLotto();
        Integer bonusNumber = askBonusNumber();

        LottoGame game = new LottoGame(bonusNumber, winningLotto, publishedLottos);
        LottoResult result = game.generateResult();
        View.printLottoResult(result, price);
    }

    private Long askPrice() {
        View.printPriceMessage();
        return inputPrice();
    }

    private List<Lotto> publishLottosFromPrice(long price) {
        List<Lotto> publishedLottos = publishLottos(getCountFromPrice(price));
        View.printPublishedLottos(publishedLottos);
        return publishedLottos;
    }

    private List<Lotto> publishLottos(Integer lottoCount) {
        List<Lotto> Lottos = new ArrayList<>();
        while (Lottos.size() < lottoCount) {
            Lotto lotto = publishRandomLotto();
            Lottos.add(lotto);
        }

        return Lottos;
    }

    private Lotto publishRandomLotto() {
        Lotto lotto;
        List<Integer> lottoNumbers = pickUniqueNumbersInRange(BOUND_START.getNumber(), BOUND_END.getNumber(), BOUND_SIZE.getNumber());
        lotto = new Lotto(lottoNumbers);

        return lotto;
    }

    private Lotto askWinningLotto() {
        View.printWinningLottoMessage();
        return new Lotto(inputWinningLotto());
    }

    private Integer askBonusNumber() {
        View.printBonusNumberMessage();
        return inputBonusNumber();
    }

    private Integer getCountFromPrice(Long Price) {
        return (int)(Price / PRICE_UNIT.getNumber());
    }
}
