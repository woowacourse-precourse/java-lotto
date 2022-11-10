package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private static final String OUTPUT_MESSAGE_TICKET_QUANTITY = "개를 구매했습니다.";

    private static final String LF = "\n";

    private final int purchaseMoney;
    private final List<Lotto> lottos;

    public LottoMachine(int purchaseMoney) {
        this.purchaseMoney = purchaseMoney;
        this.lottos = generateLottoTickets();
    }

    private List<Lotto> generateLottoTickets() {
        return IntStream.range(0, purchaseMoney / Lotto.LOTTO_TICKET_PRICE)
                .mapToObj(i -> this.generateLottoTicket())
                .collect(Collectors.toList());
    }

    private Lotto generateLottoTicket() {
        return new Lotto(generateLottoNumbers());
    }

    private List<Integer> generateLottoNumbers() {
        Set<Integer> lotto = new HashSet<>();
        while (lotto.size() < Lotto.LOTTO_SIZE) {
            lotto.add(Randoms.pickNumberInRange(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER));
        }
        return new ArrayList<>(lotto);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    @Override
    public String toString() {
        return purchaseMoney / Lotto.LOTTO_TICKET_PRICE + OUTPUT_MESSAGE_TICKET_QUANTITY + LF +
                lottos.stream()
                        .map(Lotto::toString)
                        .collect(Collectors.joining(LF));
    }
}
