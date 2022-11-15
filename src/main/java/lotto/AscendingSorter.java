package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class AscendingSorter {
    public static List<List<Integer>> sortAscendingOrder(List<List<Integer>> purchaserNumbers) {
        List<List<Integer>> sortedPurchaserNumbers = new ArrayList<>();
        for (int i = 0; i < purchaserNumbers.size(); i++) {
            sortedPurchaserNumbers.add(purchaserNumbers.get(i).stream().sorted().collect(Collectors.toList()));
        }
        return sortedPurchaserNumbers;
    }
}
