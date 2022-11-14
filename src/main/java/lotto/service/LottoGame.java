package lotto.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoCheck;
import lotto.repository.LottoAutomatonRepository;

public class LottoGame {
    private LottoAutomatonRepository automatonRepository;

    public LottoGame() {
    }

    public int calculateQuantity(String amount) {
        return automatonRepository.getCount(amount);
    }

    public List<Lotto> createLottoTickets(String amount) {
        automatonRepository = new LottoAutomatonRepository();
        return automatonRepository.createTickets(calculateQuantity(amount));
    }

    public List<Integer> toList(String input) {
        return Arrays.stream(input.split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }

    public List<String> compare(List<Integer> winnings, List<Lotto> tickets, int bonus) {
        LottoCheck check = new LottoCheck();
        List<String> checkResult = new ArrayList<>();
        for (Lotto ticket : tickets) {
            checkResult.add(check.checkRanking(winnings, ticket.getNumbers(), bonus));
        }
        return checkResult;
    }

    public void createHistory() {
        // 당첨 내역과 수익률을 계산해 저장
    }
}