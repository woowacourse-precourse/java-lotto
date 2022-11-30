package lotto.domain;

import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;

public class Lottos {
    private final List<Lotto> purchaseNumbers;

    public Lottos(List<Lotto> purchaseNumbers) {
        this.purchaseNumbers = purchaseNumbers;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner("\n");
        for (Lotto lotto : purchaseNumbers) {
            sj.add(lotto.toString());
        }
        return sj.toString();
    }


    public Iterator<Lotto> iterator() {
        return purchaseNumbers.iterator();
    }
}