package lotto.model.computer.repository;

import java.util.ArrayList;
import java.util.List;

import java.util.function.Consumer;

import lotto.model.computer.lottonumber.LottoLine;

public class LottoRepository implements Repository {

    private final List<LottoLine> lottoNumStorage = new ArrayList<>();

    @Override
    public void saveLotto(LottoLine lottoLine) {
        lottoNumStorage.add(lottoLine);
    }

    @Override
    public long sizeOfLotto() {
        return lottoNumStorage.size();
    }

    public void repositoryForEach(Consumer<LottoLine> consumer) {
        for (LottoLine lottoLine : lottoNumStorage) {
            consumer.accept(lottoLine);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LottoLine lottoLine : lottoNumStorage) {
            sb.append(lottoLine.toString()).append("\n");
        }
        return sb.toString();
    }
}
