package lotto.domain.lotto;

import static lotto.constant.ErrorMessage.ERROR_MESSAGE_OF_CONSTRUCTOR;
import static lotto.domain.utils.Number.validateRange;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class LottoNumbers {

  public LottoNumbers() {
    throw new UnsupportedOperationException(ERROR_MESSAGE_OF_CONSTRUCTOR);
  }

  /*
   * 1. 1부터 45사이의 6자리 로또 번호 랜덤 생성
   * 2. 로또 번호 중복 제거
   * 3. 3. 로또 번호가 1부터 45사이의 숫자가 아닐 경우, `IllegalArgumentException`을 반환한다.
   */
  public static List<Integer> createDistinctLottoNumbers(){
    List<Integer> numbers = Randoms
        .pickUniqueNumbersInRange(Lotto.firstLottoNumber(), Lotto.lastLottoNumber(), Lotto.lottoNumberCount());
    validateLottoNumbers(numbers);
    return removeDuplicateNumbers(numbers);
  }

  private static List<Integer> removeDuplicateNumbers(List<Integer> numbers) {
    Set<Integer> distinctNumbers = Set.copyOf(numbers);
    return new ArrayList<>(List.copyOf(distinctNumbers));
  }

  private static void validateLottoNumbers(List<Integer> numbers) {
    for(Integer number: numbers) {
      validateRange( number );
    }
  }

}
