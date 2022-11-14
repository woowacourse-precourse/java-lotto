package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private static final String LOTTO_TICKET_SIZE_IS_NOT_LOTTO_AMOUNT = "[ERROR] 랜덤으로 생성된 로또 티켓의 로또 개수가 구입한 로또 개수와 다릅니다.";

    private final List<Lotto> lottos;

    public LottoTicket(List<Lotto> lottos, int lottoAmount) {
        validateLottoTicketSize(lottos, lottoAmount);
        this.lottos = generateLottoTicket(lottoAmount);
    }

    private void validateLottoTicketSize(List<Lotto> lottos, int lottoAmount) {
        if (lottos.size() != lottoAmount) {
            throw new IllegalArgumentException(LOTTO_TICKET_SIZE_IS_NOT_LOTTO_AMOUNT);
        }
    }

    private List<Lotto> generateLottoTicket(int lottoAmount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoAmount; i++) {
            lottos.add(Lotto.generateRandomLotto());
        }
        return lottos;
    }
}