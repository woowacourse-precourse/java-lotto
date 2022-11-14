package lotto;

import lotto.utils.View;
import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.utils.Input.*;

public class GameManager {

    public GameManager() {
    }

    public void run() {
        View.printPriceMessage();
        Integer price = inputPrice();
        List<Lotto> publishedLottos = publishLottos(getCountFromPrice(price));
        View.printPublishedLottos(publishedLottos);

        View.printWinningLottoMessage();
        Lotto winningLotto = new Lotto(inputWinningLotto());

        View.printBonusNumberMessage();
        Integer bonusNumber = inputBonusNumber();

        LottoGame game = new LottoGame(bonusNumber, winningLotto, publishedLottos);
        LottoResult result = game.play();
        View.printLottoResult(result, price);
    }

    private Integer getCountFromPrice(Integer Price) {
        Integer lottoCount = Price / 1000;
        return lottoCount;
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
        List<Integer> lottoNumbers = pickUniqueNumbersInRange(1, 45, 6);
        lotto = new Lotto(lottoNumbers);

        return lotto;
    }
}
