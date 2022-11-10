package lotto.computer.repository;

import java.util.ArrayList;
import java.util.List;
import lotto.computer.lottoNumber.LottoNumber;

public class LottoRepository implements Repository{

    private final List<LottoNumber> lottoNumStorage = new ArrayList<>();

    @Override
    public void saveLotto(LottoNumber lottoNumber) {
        lottoNumStorage.add(lottoNumber);
    }

    @Override
    public int sizeOfLotto() {
        return lottoNumStorage.size();
    }

    @Override
    public void printLotto() {
        for (LottoNumber lottoNumber : lottoNumStorage) {
            System.out.println(lottoNumber);
        }
    }
}
