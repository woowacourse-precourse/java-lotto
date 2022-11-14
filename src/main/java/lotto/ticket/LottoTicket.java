package lotto.ticket;

import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoTicket {
	private final List<Integer> lottoNumbers;

    public LottoTicket() {
        this.lottoNumbers = getLottoNumbers();
    }

    public List<Integer> getLottoNumbers() {
        List<Integer> numberList = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numberList);
        return numberList;
    }
    
    public boolean contains(int lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

	public String toString() {
		return lottoNumbers.toString();
	}
    
    
}
