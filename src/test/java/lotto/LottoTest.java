package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("당첨 개수 테스트")
    @Test
    void countMatch() {
        //given
        Lotto lotto =  new Lotto(List.of(1, 2, 3, 4, 5, 6));
        //when
        int calcMatchCount = lotto.calcMatch(List.of(1, 2, 3, 4, 5, 6));
        //then
        assertThat(calcMatchCount).isEqualTo(6);
    }
    @DisplayName("로또 맞춘 해당 개수의 총 개수 테스트")
    @Test
    void matchItemCnt() {
        //given
        Lotto lotto =  new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Map<Integer, List<Integer>>> result = new ArrayList<>();
        Map<Integer, List<Integer>> mapResult = new HashMap<>();
        mapResult.put(6, List.of(1, 2, 3, 4, 5, 6));
        result.add(mapResult);
        //when
        int matchItemCount = lotto.matchItemCount(result, 0, 6);
        //then
        assertThat(matchItemCount).isEqualTo(1);
    }
    @DisplayName("로또 맞춘 해당 개수의 총 개수 테스트(보너스)")
    @Test
    void matchItemCntBonus() {
        //given
        Lotto lotto =  new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Map<Integer, List<Integer>>> result = new ArrayList<>();
        Map<Integer, List<Integer>> mapResult = new HashMap<>();
        mapResult.put(5, List.of(1, 2, 3, 4, 5, 7));
        result.add(mapResult);
        //when
        int matchItemCount = lotto.matchItemCount(result, 6, 5);
        //then
        assertThat(matchItemCount).isEqualTo(1);
    }
    @DisplayName("수익률 계산 테스트")
    @Test
    void calcBenefit() {
        //given
        Lotto lotto =  new Lotto(List.of(1, 2, 3, 4, 5, 6));
        //when
        double benefit = lotto.printBenefit(1, 0, 0, 0, 0, 8000);
        //then
        assertThat(benefit).isEqualTo(62.5);
    }
}