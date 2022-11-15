package lotto;

import java.util.List;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.Comparator;

/*
 * 무작위의 Lotto 번호를 생성하는 클래스
 */
public class LottoMachine {

    public List<Integer> createLottoNum() {
        List<Integer> lottoNumber = new ArrayList<Integer>();
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        for (Integer numbers_ : numbers) {
            lottoNumber.add(numbers_);
        }
        // lottoNumber.sort(Comparator.naturalOrder());
        Collections.sort(lottoNumber);
        // System.out.println(numbers.toString());
        return lottoNumber;
    }

    public List<Lotto> createLottoTickets(int numOfLotto) {
        List<Lotto> lottoNumbers = new ArrayList<Lotto>();
        for (int i = 0; i < numOfLotto; i++) {
            Lotto temp = new Lotto(createLottoNum());
            lottoNumbers.add(temp);
        }
        return lottoNumbers;
    }

}