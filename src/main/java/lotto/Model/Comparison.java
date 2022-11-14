package lotto.Model;

import java.util.List;

public class Comparison {

    public void compareLotto(List<Lotto> lottoNumber, WinningTicket ticket) {
        for (Lotto lotto : lottoNumber) {
            int sum = compareLottoNum(lotto.getNumbers(), ticket.getWinningTicket());
        }
    }

    private int compareLottoNum(List<Integer> numbers, Lotto ticket) {
        int count = 0;
        for (int num : ticket.getNumbers()) {
            if (numbers.contains(num)) {
                count++;
            }
        }
        return count;
    }
}
