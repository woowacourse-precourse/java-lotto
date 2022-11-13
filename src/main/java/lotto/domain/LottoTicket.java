package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;
    private static final int LOTTO_COUNT = 6;

    private final List<List<Integer>> lottoTickets = new ArrayList<>();

    public LottoTicket(int tickets){
        buyLottoTickets(tickets);
    }

    private void buyLottoTickets(int tickets){
        for (int count = 0; count < tickets; count++){
            lottoTickets.add(getLottoNumbers());
        }
    }

    private List<Integer> getLottoNumbers(){
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN, LOTTO_MAX, LOTTO_COUNT);
        OutputView.printLottoNumbers(lottoNumbers);
        return lottoNumbers;
    }
}
