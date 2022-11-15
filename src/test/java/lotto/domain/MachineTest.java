package lotto.domain;

import lotto.enums.PrizeOfLotto;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class MachineTest {

    @Test
    @DisplayName("user가 넣은 금액에 대해 구매 가능한 로또의 개수를 반환한다.")
    void countNumberOfLottos() {
        // Given
        BigInteger money = new BigInteger("999999999123123123000");

        // When
        BigInteger numberOfLottos = Machine.countNumberOfLottos(money);

        // Then
        assertThat(numberOfLottos).isEqualTo(new BigInteger("999999999123123123"));
    }

    @Test
    @DisplayName("구매 가능한 로또의 개수만큼 로또를 생성한다.")
    void generateLottos() {
        // Given
        BigInteger purchaseNumberOfLottos = new BigInteger("10000");

        // When
        List<Lotto> lottos = Machine.generateLottos(purchaseNumberOfLottos);
        BigInteger countOfPurchasedLottos = new BigInteger(String.valueOf(lottos.size()));

        // Then
        assertThat(countOfPurchasedLottos).isEqualTo(purchaseNumberOfLottos);
    }

    @Test
    @DisplayName("당첨 번호, 보너스 번호를 기준으로 로또의 등수를 판단하여 구매한 로또의 당첨 결과를 업데이트한다.")
    void judge() throws NoSuchFieldException, IllegalAccessException {
        // Given
        List<Lotto> lottos = List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        );

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;
        Machine machine = new Machine(winningNumbers, bonusNumber);

        Field resultOfLottos = machine.getClass().getDeclaredField("resultOfLottos");
        resultOfLottos.setAccessible(true);

        // When
        machine.judge(lottos);

        Map<String, Integer> result = new HashMap<>(Map.of(
                PrizeOfLotto.FIRST.getRank(), 0,
                PrizeOfLotto.SECOND.getRank(), 0,
                PrizeOfLotto.THIRD.getRank(), 0,
                PrizeOfLotto.FOURTH.getRank(), 0,
                PrizeOfLotto.FIFTH.getRank(), 1
        ));

        // Then
        assertThat(resultOfLottos.get(machine)).isEqualTo(result);
    }

    @Test
    @DisplayName("user가 투입한 금액에 대한 당첨금의 비율을 계산한다. 단, 소수점 둘째 자리에서 반올림한다.")
    void calculateRatioOfWinningsToInsertMoney() {
        // Given
        BigInteger insertMoney = new BigInteger("7000");

        // When
        Map<String, Integer> resultOfLottos = new HashMap<>(Map.of(
                PrizeOfLotto.FIRST.getRank(), 0,
                PrizeOfLotto.SECOND.getRank(), 0,
                PrizeOfLotto.THIRD.getRank(), 0,
                PrizeOfLotto.FOURTH.getRank(), 1,
                PrizeOfLotto.FIFTH.getRank(), 0
        ));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;
        Machine machine = new Machine(winningNumbers, bonusNumber);
        float ratio = machine.calculateRatioOfWinningsToInsertMoney(resultOfLottos, insertMoney);

        // Then 1
        float result = (float) 714.3;
        assertThat(ratio).isEqualTo(result);

        // Then 2
        String ratioStr = String.valueOf(ratio);
        int ratioScale = ratioStr.length() - (ratioStr.indexOf(".") + 1);
        assertThat(ratioScale).isEqualTo(1);
    }

}