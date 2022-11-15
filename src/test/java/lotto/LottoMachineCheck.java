package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineCheck {

    @DisplayName("스트림으로 중복 제거에 대한 테스트")
    @Test
    void checkUseSteamToRemoveDuplication() {
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 5);

        List<Integer> removedDuplicationNumber =
                winningNumber.stream()
                        .distinct()
                        .collect(Collectors.toList());

        assertThat(removedDuplicationNumber).isEqualTo(List.of(1, 2, 3, 4, 5));
    }

    @DisplayName("스트림으로 리스트 정렬하는 것에 대한 테스트")
    @Test
    void checkUseSteamToSortList() {
        List<Integer> winningNumber = List.of(6, 5, 4, 3, 2, 1);

        List sortedList = Arrays.stream(winningNumber.toArray())
                .sorted()
                .collect(Collectors.toList());

        assertThat(sortedList).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("두개의 리스트 합치는 로직 테스트")
    @Test
    void checkMergeTwoList(){
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> normalLotto = List.of(6, 5, 4, 3, 2, 1);

        List<Integer> mergeLottoNumbers = mergeList(winningLotto, normalLotto);

        assertThat(mergeLottoNumbers.size()).isEqualTo(12);
    }

    @DisplayName("소수점 두번쨰 자리에서 반올림 로직 테스트")
    @Test
    void checkRoundingAtSecondSpot(){
        int profit = 5000;
        int userMoney = 8000;

        double rateEarningMoney = profit/(double)userMoney*100;
        rateEarningMoney = Math.round(rateEarningMoney*10)/10.0;
        assertThat(rateEarningMoney).isEqualTo(62.5d);
    }

    static List<Integer> mergeList(List<Integer> list1, List<Integer> list2){
        List<Integer> mergeList = new ArrayList<>();
        Collections.addAll(mergeList, list1.toArray(new Integer[0]));
        Collections.addAll(mergeList, list2.toArray(new Integer[0]));

        return mergeList;
    }
}
