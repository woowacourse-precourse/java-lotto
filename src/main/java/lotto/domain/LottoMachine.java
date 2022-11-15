package lotto.domain;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoMachine {
    private final lotto.domain.LottoNumberGenerator generator;
    private final lotto.domain.LottoPurchaseMoney lottoPurchaseMoney;
    private lotto.domain.LottoTickets lottoTickets;

    public LottoMachine(lotto.domain.LottoPurchaseMoney lottoPurchaseMoney) {
        this.generator = new lotto.domain.LottoNumberGenerator();
        this.lottoPurchaseMoney = lottoPurchaseMoney;
    }

    public void purchase(List<String> manualDraws) {
        Set<Lotto> manualTickets = convertManualDrawsToLottoTickets(manualDraws);
        lottoTickets = new lotto.domain.LottoTickets(manualTickets);
    }

    public lotto.domain.LottoResult confirm(lotto.domain.WinningNumbers winningNumbers) {
        return new lotto.domain.LottoResult(lottoTickets.findWinner(winningNumbers), lottoPurchaseMoney.getInvestMoney());
    }

    public String ticketsToString() {
        return lottoTickets.toString();
    }

    public int ticketsCount() {
        return lottoTickets.totalCount();
    }

    private Set<Lotto> convertManualDrawsToLottoTickets(List<String> manualDrawList) {
        Set<Lotto> manualTickets = new HashSet<>();

        if (manualDrawList.isEmpty()) {
            return manualTickets;
        }

        manualDrawList.forEach(manualDraw -> manualTickets.add(convertManualDrawToLottoTicket(manualDraw)));
        return manualTickets;
    }

    private Lotto convertManualDrawToLottoTicket(String manualDraw) {
        List<Integer> manualTicket = (List<Integer>) Arrays.stream(manualDraw.split("\\s*,\\s*"))
                .map(Integer::parseInt)
                .map(Integer::new)
                .collect(Collectors.toSet());
        return new Lotto(manualTicket);
    }
}