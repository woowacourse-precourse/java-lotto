package lotto.model.computer.repository;

import lotto.model.computer.lottonumber.LottoLine;

public interface Repository {

    void saveLotto(LottoLine lottoLine);

    long sizeOfLotto();
}
