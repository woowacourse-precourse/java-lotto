package lotto.domain;

import java.util.List;

/**
 * 로또 보너스 번호
 *
 * @version 1.0.0
 * @author chlskreh2
 */
public class LottoBonusBall {

    private final int bonusBall;

    public LottoBonusBall(int bonusBall, Lotto lotto) {
        validate(bonusBall);
        validateDuplicationByLotto(bonusBall, lotto);
        this.bonusBall = bonusBall;
    }

    /**
     * 로또 보너스 번호 범위 적합성 로직
     */
    private void validate(int bonusBall) {
        if (bonusBall < 1 || bonusBall > 45) {
            System.out.println("[ERROR] 로또 보너스 번호는 1부터 45사이의 숫자를 입력하셔야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    /**
     * 로또 보너스 번호 중복 체크 로직
     */
    private void validateDuplicationByLotto(int bonusBall, Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        if (numbers.contains(bonusBall)) {
            System.out.println("[ERROR] 로또 보너스 번호는 로또 당첨 번호들과 중복되지 않는 숫자를 입력하셔야 합니다.");
            throw new IllegalArgumentException();
        }
    }

}
