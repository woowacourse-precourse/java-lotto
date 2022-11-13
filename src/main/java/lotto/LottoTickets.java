package lotto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LottoTickets {
    private static final int COUNT_NUM = 1;
    private final List<Lotto> lottos = new ArrayList<>();
    public LottoTickets(int count) {
        getTickets(count);
    }
    public void getTickets(int count) {
        while (count > 0) {
            lottos.add(LottoGenerate.generateLotto());
            count -= COUNT_NUM;
        }
    }
    public List<Lotto> getLotto() {
        return Collections.unmodifiableList(lottos);
    }
}
