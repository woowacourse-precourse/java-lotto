package lotto.service;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LottoService {
    private List<Lotto> lotteries = new ArrayList<>();
    private List<Integer> winnings = new ArrayList<>();
    private int bonus;

    public LottoService() {

    }

    public void addLotteries(int buyNumber) {
        while (buyNumber != 0) {
            List<Integer> randomNumbers = Lotto.createRandomNumbers();
            Lotto lotto = new Lotto(randomNumbers);
            lotteries.add(lotto);
            buyNumber--;
        }
    }

    public void printLotteries() {
        for (Lotto lotto : lotteries) {
            System.out.println(lotto.getNumbers());
        }
    }

    private int checkWinningNumber(List<Integer> lottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(number -> winnings.stream()
                        .anyMatch(Predicate.isEqual(number)))
                .count();
    }
    private boolean checkBonusNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .anyMatch(number -> number.equals(bonus));
    }
}
