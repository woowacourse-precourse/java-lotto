package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.LottoConst.LOTTO_NUMBER_COUNT;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineCheck {

    @DisplayName("당첨 로또와 일반 로또 비교 후 얼마나 많은 숫자를 맞췄는지 반환하는 로직 테스트")
    @Test
    void checkHowMachWithWinningNumber(){
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> normalLotto = List.of(6, 5, 4, 3, 2, 1);

        List<Integer> mergeLottoNumbers = mergeList(winningLotto, normalLotto);
        List<Integer> distinctLottoNumbers = mergeLottoNumbers.stream()
                .distinct()
                .collect(Collectors.toList());

        assertThat(distinctLottoNumbers.size()).isEqualTo(6);
    }

    static List<Integer> mergeList(List<Integer> list1, List<Integer> list2){
        List<Integer> mergeList = new ArrayList<>();
        Collections.addAll(mergeList, list1.toArray(new Integer[0]));
        Collections.addAll(mergeList, list2.toArray(new Integer[0]));

        return mergeList;
    }
}
