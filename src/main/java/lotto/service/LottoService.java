package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoRepository;
import lotto.domain.Money;
import lotto.type.Prize;
import lotto.view.LottoDto;
import lotto.view.PrizeDto;

public class LottoService {
    private final LottoRepository lottoRepository;

    public LottoService(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    public List<List<Integer>> createLottos(Money money) {
        List<List<Integer>> numbers = new ArrayList<>();
        for (int i = 0; i <money.calcLottoQuantity(); i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(randomNumbers);
            numbers.add(lottoRepository.save(lotto));
        }
        return numbers;
    }

    public PrizeDto calcWinningResult(List<Integer> winningNumbers,int bonusNumber, Money money) {
        List<Prize> prizes = confirmWinning(winningNumbers, bonusNumber);
        Double yield = calcYield(prizes, money);
        return new PrizeDto(prizes, yield);
    }

    private Double calcYield(List<Prize> prizes, Money money) {
        Long prizeMoney = prizes.stream()
                .map(Prize::getPrizeMoney)
                .reduce(Long::sum)
                .orElse(1L);
        return money.calcYield(prizeMoney);

    }

    private List<Prize> confirmWinning(List<Integer> winningNumbers, Integer bonusNumber) {
        List<Lotto> lottos = lottoRepository.findAll();
        return lottos.stream()
                .map(lotto -> lotto.compareWinningNumbers(winningNumbers, bonusNumber))
                .filter(prize -> !Prize.NOTING.equals(prize))
                .collect(Collectors.toList());

    }

}
