package repository;

import domain.Lotto;
import service.Winner;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class LottoRepository {
    private final List<Lotto> publishedLotto = new ArrayList<>();
    private final List<Integer> winningNumbers = new ArrayList<>();
    private int bonusNumber;
    private EnumMap<Winner, Integer> winners = new EnumMap<>(Winner.class);

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

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    public void saveWinners(EnumMap<Winner, Integer> winners) {
        this.winners = winners;
    }

    public EnumMap<Winner, Integer> getWinners() {
        return this.winners;
    }
}
