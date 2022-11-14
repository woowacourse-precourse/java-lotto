package lotto.management;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.LottoTicketIntegration;
import lotto.exception.Lotto;

import java.util.ArrayList;
import java.util.List;


public class LottoRandomNumber {
    private final int LottoTicketsNumber;
    private final int LOTTO_START_NUMBER = 1;
    private final int LOTTO_END_NUMBER = 45;
    private final int LOTTO_NUMBERS_SIZE = 6;
    private final LottoTicketIntegration lottoTicketIntegration;
    private List<Integer> randomNumbers = new ArrayList<>();
    private Lotto lotto;

    LottoRandomNumber(int lottoTicketsNumber) {
        this.LottoTicketsNumber = lottoTicketsNumber;
        this.lottoTicketIntegration = new LottoTicketIntegration();
    }

    public void generateRandomNumbers() {
        for (int ticket = 0; ticket < LottoTicketsNumber; ticket++) {
            randomNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_NUMBERS_SIZE);
            lotto = new Lotto(randomNumbers);
            lottoTicketIntegration.put(lotto.getNumbers());
        }
    }

    public List<List<Integer>> getRandomNumbers(){
        return lottoTicketIntegration.getLottoTicketIntegration();
    }
}
