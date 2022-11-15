package lotto.domain;

import lotto.view.ConsoleOutput;

import java.util.ArrayList;
import java.util.List;

public class LottoList {
    List<Lotto> lottoList = new ArrayList<>();

    public void addLottoList(Lotto lotto) {
        this.lottoList.add(lotto);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Lotto lotto : lottoList) {
            str.append(lotto.toString());
        }
        return str.toString();
    }
}
