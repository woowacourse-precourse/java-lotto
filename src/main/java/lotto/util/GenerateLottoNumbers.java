package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateLottoNumbers {
    public List<Integer> listSort(List<Integer> unsortedList) {
        List<Integer> sortedList = new ArrayList<>(unsortedList);
        Collections.sort(sortedList);
        return sortedList;
    }
}
