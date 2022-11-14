package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class WinningNumberToList {
    public List<Integer> winNumbers;

    public WinningNumberToList() {
        winNumbers = new ArrayList<>();
    }

    public void setWinNumbers(String winNums) {
        StringTokenizer st = new StringTokenizer(winNums, ",");
        while (st.hasMoreTokens()) {
            winNumbers.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(winNumbers);
    }
}
