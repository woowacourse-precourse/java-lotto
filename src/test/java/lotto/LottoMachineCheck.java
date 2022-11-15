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

        Arrays.stream(winningNumber.toArray())
                .sorted()
                .collect(Collectors.toList());

        assertThat(winningNumber).isEqualTo(List.of(1, 2, 3, 4, 5,6));
    }

    static List<Integer> mergeList(List<Integer> list1, List<Integer> list2){
        List<Integer> mergeList = new ArrayList<>();
        Collections.addAll(mergeList, list1.toArray(new Integer[0]));
        Collections.addAll(mergeList, list2.toArray(new Integer[0]));

        return mergeList;
    }
}
