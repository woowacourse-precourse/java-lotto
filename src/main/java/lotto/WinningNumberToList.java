package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class WinningNumberToList {
    public List<Integer> winNumbers;

    public WinningNumberToList() {
        winNumbers = new ArrayList<>();
    }

    public void setWinNumbers(String winNums) {
        StringTokenizer st = new StringTokenizer(winNums, ",");
        for(int i=0; i<6; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num<1 || num >45)
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");

            winNumbers.add(num);
        }
    }
}
