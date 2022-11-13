package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
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

    public void compare() {
        // 당첨 번호, 보너스 번호와 비교해 등수를 확인
    }

    public void createHistory() {
        // 당첨 내역과 수익률을 계산해 저장
    }
}