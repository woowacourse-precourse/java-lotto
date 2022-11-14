package lotto.domain;

import lotto.Lotto;
import lotto.view.ConsoleOutput;

import java.util.ArrayList;
import java.util.List;

public class LottoList {
    List<Lotto> lottoList = new ArrayList<>();

    public void addLottoList(Lotto lotto) {
        this.lottoList.add(lotto);
    }

    public void printLottoList(int amount) {
        ConsoleOutput output = new ConsoleOutput();
        output.LottoAmount(amount);
        for(Lotto lotto : this.lottoList){
            System.out.println(lotto.getNumbers());
        }
    }
}
