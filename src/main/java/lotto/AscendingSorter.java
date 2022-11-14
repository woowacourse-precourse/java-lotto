package lotto;

import java.util.Collections;
import java.util.List;

public class AscendingSorter {
    public List<List<Integer>> sortAscendingOrder(List<List<Integer>> purchaserNumbers) {
        for (int i = 0; i < purchaserNumbers.size(); i++) {
            Collections.sort(purchaserNumbers.get(i));
        }
        return purchaserNumbers;
    }
}
