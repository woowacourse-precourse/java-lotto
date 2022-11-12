package lotto.view;

import lotto.Lotto;

import java.util.List;

public class LottoListView implements View{
    private List<Lotto> lottos;

    public LottoListView(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    @Override
    public void print() {
        for(Lotto lotto:lottos){
            System.out.println(lotto.getNumbers());
        }
    }
}
