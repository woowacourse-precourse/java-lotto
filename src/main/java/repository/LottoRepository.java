package repository;

import domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoRepository {
    private final List<Lotto> publishedLotto = new ArrayList<>();
    private final List<Integer> winningNumbers = new ArrayList<>();

    public void save(Lotto lotto) {
        publishedLotto.add(lotto);
    }

    public List<Lotto> getPublishedLotto() {
        return this.publishedLotto;
    }

    public void saveWinningNumbers(List<Integer> numbers) {
        this.winningNumbers.addAll(numbers);
    }
}
