package lotto.domain;

import java.util.ArrayList;

public class Lottos {
    private ArrayList<Lotto> lottos;

    public Lottos(){
        lottos = new ArrayList<>();
    }

    public void addLotto(Lotto lotto){
        this.lottos.add(lotto);
    }

    public ArrayList<Lotto> getLotts(){
        return this.lottos;
    }
}
