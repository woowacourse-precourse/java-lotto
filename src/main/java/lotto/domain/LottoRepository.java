package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoRepository {
    private List<Lotto> lottoRepository = new ArrayList<>();

    public void add(Lotto lotto) {
        lottoRepository.add(lotto);
    }

    public int size() {
        return lottoRepository.size();
    }

    public Lotto get(int index) {
        return lottoRepository.get(index);
    }

    public void printAllLotto() {
        lottoRepository.forEach(Lotto::printLottoInfo);
    }
}
