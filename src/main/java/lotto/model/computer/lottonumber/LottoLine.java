package lotto.model.computer.lottonumber;

import java.util.List;
import java.util.function.Consumer;

public class LottoLine {

    private final List<Integer> lotto;

    public LottoLine(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public void lottoNumberForEach(Consumer<Integer> consumer) {
        for (Integer lottoNumber : lotto) {
            consumer.accept(lottoNumber);
        }
    }

    @Override
    public String toString() {
        return this.lotto.toString();
    }
}
