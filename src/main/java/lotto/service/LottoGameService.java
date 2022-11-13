package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGameService {

    private OutputView outputView;
    public List<Lotto> pickLottos(int ticketCnt) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i=0; i<ticketCnt; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoList.add(new Lotto(numbers));
            outputView.printLottoNumbers(numbers);
        }
        return lottoList;
    }

}
