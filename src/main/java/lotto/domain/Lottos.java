package lotto.domain;

import java.util.ArrayList;

public class Lottos {
    private final ArrayList<Lotto> lottos;

    public Lottos(){
        lottos = new ArrayList<>();
    }

    public void addLotto(Lotto lotto){
        this.lottos.add(lotto);
    }

    public ArrayList<Lotto> getLottos(){
        return this.lottos;
    }

    public int getLottoCount(){
        return this.lottos.size();
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();

        for(Lotto lotto: lottos){
            result.append(lotto.toString()).append("\n");
        }

        return result.toString();
    }
}
