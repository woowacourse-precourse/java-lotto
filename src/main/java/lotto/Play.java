package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import utils.Output;
import utils.UserInput;

import java.util.ArrayList;
import java.util.List;

import static constant.Constant.INITIAL_NUMBER;
import static constant.Constant.MONEY_UNIT;

public class Play {

    public void start() {
        int numOfLotto = UserInput.inputPrice();
        List<Lotto> lottoTickets = createLottoTickets(numOfLotto);
        Output.showLottoTickets(lottoTickets);

        LottoNumber lottoNumber = UserInput.inputWinningNumbers();
        Result result = new Result(lottoTickets, lottoNumber);
        result.calculateReturnOfRate(numOfLotto*MONEY_UNIT);
    }

    private List<Lotto> createLottoTickets(int numOfLotto) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i=INITIAL_NUMBER; i<numOfLotto; i++) {
            lottoTickets.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottoTickets;
    }

}
