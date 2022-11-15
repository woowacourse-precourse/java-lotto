package lotto.controller;

import java.util.Set;

public interface LottoReader {
    int readAmount();
    Set<Integer> readLottoNumber();
    int readBonus();
}
