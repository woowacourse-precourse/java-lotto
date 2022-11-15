package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Publishing {

    List<Lotto> lottoList = new ArrayList<>();

    public void publishingLotto(Integer number) {
        for (int i=0; i<number; i++) {
            List<Integer> numbers = makeLottoNumber();
            System.out.println(numbers);

            Lotto lotto = new Lotto(numbers);
            lottoList.add(lotto);
        }
    }

    public List<Integer> makeLottoNumber() {
      List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, Unit.LOTTO_NUMBER_UNIT.getUnit());
      numbers.sort(Comparator.naturalOrder());
      return numbers;
    }

      public List<Lotto> getLottoList() {
          return lottoList;
      }
}
