package domain;

import view.Input;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<List<Integer>> lottos;

    private NumberGenerator numberGenerator;

    private int numberOfLotto;

    public Lottos(int number) {
        lottos = new ArrayList<>();
        numberGenerator = new NumberGenerator();
        numberOfLotto = number;
    }

    public List<List<Integer>> getLottos() {
        return this.lottos;
    }

    public NumberGenerator getNumberGenerator() {
        return this.numberGenerator;
    }

    public int getNumberOfLotto() {
        return this.numberOfLotto;
    }

    public void generateLottos() {
        for(int i = 0; i < numberOfLotto; i++) {
            NumberGenerator numberGenerator = new NumberGenerator();
            lottos.add(numberGenerator.getLotto().getNumbers());
        }
    }
}
