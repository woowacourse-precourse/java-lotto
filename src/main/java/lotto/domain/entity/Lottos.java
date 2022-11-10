package lotto.domain.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Generator;

public class Lottos {

    private Generator generator;

    private List<Lotto> lottos;

    private Lottos(int amountOfLotto, Generator generator) {
        lottos = new ArrayList<>();
        this.generator = generator;
        settingLottos(amountOfLotto);
    }



    private void settingLottos(int amountOfLotto) {
        for (int i = 0; i < amountOfLotto; i++) {
            List<Integer> unSortedLottoNumbers = generator.lottoNumbersGenerator();
            Collections.sort(unSortedLottoNumbers);
            lottos.add(new Lotto(unSortedLottoNumbers));
        }
    }

    public static Lottos of(int amountOfLotto, Generator generator) {
        return new Lottos(amountOfLotto, generator);
    }

    public List<Lotto> currentLottos() {
        return lottos;
    }

    public void printWholeLottoNumbers() {
        lottos.stream().forEach(lotto -> lotto.printLottoNumbers());
    }
}
