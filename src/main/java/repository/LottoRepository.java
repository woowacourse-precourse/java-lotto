package repository;

import domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoRepository {
    private final List<Lotto> publishedLotto = new ArrayList<>();
    private final List<Integer> winningNumbers = new ArrayList<>();
    private int bonusNumber;

    public void save(Lotto lotto) {
        publishedLotto.add(lotto);
    }

    public List<Lotto> getPublishedLotto() {
        return this.publishedLotto;
    }

    public void saveWinningNumbers(List<Integer> numbers) {
        this.winningNumbers.addAll(numbers);
    }

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }

    public void saveBonusNumber(int number) {
        this.bonusNumber = number;
    }
}
