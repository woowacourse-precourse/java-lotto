package lotto.model;

import java.util.List;

public class LottoGroup {
    private final List<Lotto> lottos;

    public LottoGroup(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public String getLottosString(){
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto.getNumbersString());
            sb.append("\n");
        }
        return sb.toString().trim();
    }


}
