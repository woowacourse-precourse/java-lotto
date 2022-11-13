package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Purchaser {
    private int money;
    private int numberOfLotto;
    private List<Lotto> lottos;

    public Purchaser() {
        lottos = new ArrayList<>();
    }
}