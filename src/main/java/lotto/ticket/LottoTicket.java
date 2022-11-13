package lotto.ticket;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoTicket {
	private final Set<Integer> lottoNumbers;

    public LottoTicket() {
        this.lottoNumbers = new HashSet<>();
    }

    public List<Integer> getLottoNumbers() {
        List<Integer> numberList = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numberList);
        return numberList;
    }
    
    public boolean contains(int lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }
}
