package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGameService {

    private OutputView outputView;
    public List<Lotto> pickLottos(int ticketCnt) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i=0; i<ticketCnt; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoList.add(new Lotto(numbers));
            outputView.printLottoNumbers(sortAscending(numbers));
        }
        return lottoList;
    }

    private List<Integer> sortAscending(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }

}
