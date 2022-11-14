package domain;

import view.Input;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<List<Integer>> lottos;

    private final int numberOfLotto;

    public Lottos(int number) {
        numberOfLotto = number;
        lottos = new ArrayList<>();
        generate();
    }

    public List<List<Integer>> getLottos() {
        return this.lottos;
    }

    public int getNumberOfLotto() {
        return this.numberOfLotto;
    }

    public void generate() {
        for(int i = 0; i < numberOfLotto; i++) {
            NumberGenerator numberGenerator = new NumberGenerator();
            lottos.add(numberGenerator.getLotto().getNumbers());
        }
    }
}
