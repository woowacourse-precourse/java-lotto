package lotto.filter;

import java.util.List;
import lotto.publisher.WinnerLotto;

public class BonusDuplicationFilter implements Filter {
    @Override
    public void doFilter(String target) {
        int number = Integer.parseInt(target);

        List<Integer> existLottoNumbers =
                WinnerLotto.getInstance().getWinningLotto().getNumbers();

        for (int i : existLottoNumbers) {
            if (i == number) {
                throw new IllegalArgumentException("이미 존재하는 당첨 번호입니다.");
            }
        }
    }
}
