package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Draw {
    private List<Integer> winNum = new ArrayList<>();
    private int bonusNum;
    private List<Lotto> lottos;

    public Draw(List<Integer> winNum, int bonusNum, List<Lotto> lottos) {
        this.winNum = winNum;
        this.bonusNum = bonusNum;
        this.lottos = lottos;
    }
}
