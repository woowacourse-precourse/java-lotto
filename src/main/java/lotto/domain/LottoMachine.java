package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.utils.Constants.*;

public class LottoMachine {
    private final int purchaseMoney;
    private final List<Lotto> lottos;

    public LottoMachine(int purchaseMoney) {
        this.purchaseMoney = purchaseMoney;
        this.lottos = generateLottoTickets();
    }

    private List<Lotto> generateLottoTickets() {
        return IntStream.range(0, purchaseMoney / LOTTO_TICKET_PRICE)
                .mapToObj(i -> this.generateLottoTicket())
                .collect(Collectors.toList());
    }

    private Lotto generateLottoTicket() {
        return new Lotto(generateLottoNumbers());
    }

    private List<LottoNumber> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE).stream()
                .map(LottoNumber::new)
                .sorted()
                .collect(Collectors.toList());
    }

    public WinningStatics enterWinningLotto(WinningLotto winningLotto) {
        WinningStatics winningStatics = new WinningStatics();
        lottos.stream()
                .map(winningLotto::makeResult)
                .filter(LottoResult::isNotFailed)
                .forEach(winningStatics::updateLottoResults);
        winningStatics.calculateRateOfReturn(purchaseMoney);
        return winningStatics;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    @Override
    public String toString() {
        return String.format(OUTPUT_MESSAGE_TICKET_QUANTITY, purchaseMoney / LOTTO_TICKET_PRICE) +
                lottos.stream()
                        .map(Lotto::toString)
                        .collect(Collectors.joining(LF));
    }
}
