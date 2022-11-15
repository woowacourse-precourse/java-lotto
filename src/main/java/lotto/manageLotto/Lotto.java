package lotto.manageLotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 당첨 번호와 발행된 로또에 대한 확인 담당
public class Lotto {
    /**
     * 주의 사항
     * 1. 제공된 Lotto 클래스를 활용해 구현해야 한다.
     * 2. Lotto에 매개 변수가 없는 생성자를 추가할 수 없다.
     * 3. numbers의 접근 제어자인 private을 변경할 수 없다.
     * 4. Lotto에 필드(인스턴스 변수)를 추가할 수 없다.
     * 5. Lotto의 패키지 변경은 가능하다.
     */

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        Set<Integer> setOfLottoNumbers = new HashSet<>(numbers);
        if (setOfLottoNumbers.size() != LottoManager.LOTTO_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * TODO: 로또와 일치하는 숫자의 개수 반환
     *
     * @param lotto 발행된 로또
     * @return 발행된 로또와 사용자가 입력한 당첨 번호 사이 일치하는 숫자의 개수
     */
    public int countSameLottoNumber(List<Integer> lotto) {
        int numberOfSameLottoNumber = 0;

        for (int userPredictLottoNumber : numbers) {
            if (lotto.contains(userPredictLottoNumber)) {
                numberOfSameLottoNumber++;
            }
        }
        return numberOfSameLottoNumber;
    }

    /**
     * TODO: 보너스 번호 확인
     *
     * @param lotto                  발행된 로또
     * @param userPredictBonusNumber 사용자가 입력한 보너스 번호
     * @return 발행된 로또에 보너스 번호가 들어있다면 true / 없다면 false
     */
    public boolean checkBonusLottoNumber(List<Integer> lotto, int userPredictBonusNumber) {
        return lotto.contains(userPredictBonusNumber);
    }

}
