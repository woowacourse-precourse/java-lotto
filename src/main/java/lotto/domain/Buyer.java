package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Buyer {

    private List<Lotto> lottos = new ArrayList<>();
    public static Buyer newInstance() {
        return new Buyer();
    }

    public void selectLotto(Lotto lotto) {
        if (notSameWith(lotto)) {
            lottos.add(lotto);
        }
    }
    public void buyLotto(int number) {
        while (lottos.size()<number) {
            selectLotto(Lotto.generateRandomLotto());
        }
    }
    private boolean notSameWith(Lotto newLotto) {
        return lottos.stream()
                .allMatch(Predicate.not(lotto -> equals(newLotto)));
    }
    public void showAllLotto() {
        lottos.stream()
                .forEach(System.out::println);
    }
    public History play(WinningNumber winningNumber) {
        History history = History.newInstance();
        lottos.stream()
                .map(lotto -> lotto.play(winningNumber))
                .forEach(history::report);
        return history;
    }
}
