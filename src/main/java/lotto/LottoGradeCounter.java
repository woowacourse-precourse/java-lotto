package lotto;

import java.util.ConcurrentModificationException;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;

public class LottoGradeCounter {
    private final Map<LottoGrade, Integer> counter;

    public LottoGradeCounter() {
        this.counter = new EnumMap<>(LottoGrade.class);
        for (LottoGrade lottoGrade : LottoGrade.values()) {
            counter.put(lottoGrade, 0);
        }
    }

    private LottoGradeCounter(Map<LottoGrade, Integer> counter) {
        this.counter = counter;
    }

    public LottoGradeCounter getPrintList() {
        Map<LottoGrade, Integer> copyCounter = new EnumMap<>(counter);
        copyCounter.remove(LottoGrade.BANG);

        return new LottoGradeCounter(copyCounter);
    }

    public void countByOne(LottoGrade lottoGrade) {
        counter.put(lottoGrade, counter.get(lottoGrade) + 1);
    }

    public void forEach(BiConsumer<LottoGrade, Integer> action) {
        Objects.requireNonNull(action);
        for (Map.Entry<LottoGrade, Integer> entry : counter.entrySet()) {
            LottoGrade k;
            Integer v;
            try {
                k = entry.getKey();
                v = entry.getValue();
            } catch (IllegalStateException ise) {
                // this usually means the entry is no longer in the map.
                throw new ConcurrentModificationException(ise);
            }
            action.accept(k, v);
        }
    }

}
