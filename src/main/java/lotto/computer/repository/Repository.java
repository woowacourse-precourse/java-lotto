package lotto.computer.repository;

import lotto.computer.lottoNumber.LottoNumber;

public interface Repository {

    void saveLotto(LottoNumber lottoNumber);

    int sizeOfLotto();

    void printLotto();
}
