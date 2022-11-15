package lotto.domain.player;

import lotto.domain.game.generator.NumberGenerator;
import lotto.domain.lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;
    private NumberGenerator numberGenerator;

    public Lottos(NumberGenerator numberGenerator) {
        this.lottos = new ArrayList<>();
        this.numberGenerator = numberGenerator;
    }

    public void generateLottos(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            this.generateLotto();
        }
    }

    private void generateLotto() {
        lottos.add(new Lotto(numberGenerator.generate()));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
