package lotto;

import java.util.List;

public class Lotto {

    private final List<Lotto> lottos = new ArrayList<>();

    public Lotto(final List<Lotto> lottos) {
        addLottoByManual(lottos);
    }

    public Lotto(final LottoMachine lottoMachine, final int ticketCount) {
        addLottoByTicket(lottoMachine, ticketCount);
    }

    public Lotto(final List<Lotto> lottos, final LottoMachine lottoMachine,
        final int ticketCount) {
        addLottoByManual(lottos);
        addLottoByTicket(lottoMachine, ticketCount);
    }

    private void addLottoByTicket(final LottoMachine lottoMachine, final int ticketCount) {
        for (int i = 0; i < ticketCount; i++) {
            lottos.add(Lotto.from(lottoMachine.generate()));
        }
    }

    private void addLottoByManual(final List<Lotto> lottos) {
        this.lottos.addAll(lottos);
    }

    public RatingInfo scratchLotto(final WinningLotto winningLotto) {
        final RatingInfo ratingInfo = new RatingInfo();
        for (final Lotto lotto : lottos) {
            final int match = winningLotto.compareLottoNumber(lotto);
            final boolean hasBonusBall = winningLotto.compareBonusBall(lotto);
            ratingInfo.update(Rating.getRating(match, hasBonusBall));
        }
        return ratingInfo;
    }

    public List<Lotto> toList() {
        return Collections.unmodifiableList(lottos);
    }

}