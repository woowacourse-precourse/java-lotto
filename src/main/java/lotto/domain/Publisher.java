package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Publisher {

    private List<Lotto> lottos;
    private int bonusNumber;

    public List<Lotto> createLottos(int count) {
        lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(NumberGenerator.createDifferentRandomNumbers()));
        }

        return lottos;
    }

    public void createBonusNumber() {
        bonusNumber = NumberGenerator.createRandomNumber();
    }

    public void printLottos() {
        lottos.forEach(System.out::println);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
