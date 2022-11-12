package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoService {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;


    public LottoService(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    /**
     * 1-45 범위의 6자리 랜덤 숫자를 만들어 Lotto 객체를 반환
     * @return 랜덤 숫자가 부여된 Lotto 객체
     */
    public Lotto generateLotto(){
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        randomNumbers.sort(null);
        Lotto lotto = new Lotto(randomNumbers);

        return lotto;
    }
}
