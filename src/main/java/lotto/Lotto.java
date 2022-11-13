package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        ValidatePlayerNumber(numbers);
        this.numbers = numbers;
    }

    /**
     * 사용자가 입력한 로또 숫자의 유효성을 검증한다.
     * 1에서 45까지 서로 다른 임의의 수 7개인지 검증
     * @param playerNumbers 사용자가 입력한 로또 숫자
     */
    private static void ValidatePlayerNumber(List<Integer> playerNumbers) {
        // 집합에 게임 플레이어가 입력한 숫자를 넣는다.
        HashSet<Integer> playerNumber = Model.MakeNumberToSet(playerNumbers);

        // 집합의 크기가 7이 아니거나 1에서 45까지의 숫자가 아닌 숫자를 포함하면 예외를 발생한다.
        if (playerNumber.size() != 7 || Collections.min(playerNumber) < 1 || Collections.max(playerNumber) > 45) {
            throw new IllegalArgumentException("[ERROR] 입력된 당첨 번호와 보너스 번호가 유효하지 않습니다.");
        }
    }

    /**
     * 사용자가 입력한 로또 구입 금액을 검증한다.
     * 1000으로 나누었을 때 몫이 1 미만이거나 나머지가 0이 아니면 예외가 발생
     * @param purchaseAmount 사용자가 입력한 로또 구입 금액
     */
    private static void ValidatePurchaseAmount(Integer purchaseAmount) {
        if (purchaseAmount / 1000 < 1) {
            throw new IllegalArgumentException("[ERROR] 구입 금액이 유효하지 않습니다.");
        }
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액이 유효하지 않습니다.");
        }
    }
}
