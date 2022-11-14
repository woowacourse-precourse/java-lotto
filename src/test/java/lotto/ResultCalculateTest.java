package lotto;

import net.bytebuddy.matcher.CollectionSizeMatcher;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.*;

class ResultCalculateTest {
    @DisplayName("List는 선언시 빈 공간이 할당되는가?")
    @Test
    void 선언만하고_값넣어보기(){
        List<Integer> example = new LinkedList<>();
        assertThatThrownBy(()->example.set(6,1))
                .isInstanceOf(IndexOutOfBoundsException.class);
        List<Integer> example2 = new ArrayList<>(7);
        assertThatThrownBy(()->example2.set(6,10))
             .isInstanceOf(IndexOutOfBoundsException.class);
    }
    @DisplayName("2가지의 일련 번호들 사이에 같은 번호의 수 찾기")
    @Test
    void 모든번호가_같음() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7);
        assertThat(1).isEqualTo(ResultCalculate.compareTwoNumbers(lotto,numbers));
    }
    @Test
    void 일부만_같음(){
        assertThat(2)
                .isEqualTo(ResultCalculate
                .compareTwoNumbers(new Lotto(Arrays.asList(1,2,3,4,5,10)),List.of(1,2,3,4,11,7,10))
                );
        assertThat(3)
                .isEqualTo(ResultCalculate
                .compareTwoNumbers(new Lotto(Arrays.asList(1,2,3,4,5,10)),List.of(1,2,3,4,11,10,7))
                );
        assertThat(4)
                .isEqualTo(ResultCalculate
                .compareTwoNumbers(new Lotto(Arrays.asList(1,2,3,4,11,10)),List.of(1,2,3,4,5,6,7))
                );
    }
    @Test
    void 다_다름(){
        assertThat(-1)
                .isEqualTo(ResultCalculate
                .compareTwoNumbers(new Lotto(Arrays.asList(1,2,3,4,5,6)),List.of(7,8,9,10,11,12,13))
                );
    }
    @DisplayName("2가지 일련번호에서 적절한 등수 List를 찾아내는지")
    @Test
    void 다_같음(){
        List<Lotto> lottos = new LinkedList<>();
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7);
        lottos.add(new Lotto(Arrays.asList(1,2,3,4,5,6))); //1등
        lottos.add(new Lotto(Arrays.asList(1,2,3,4,10,7))); //2등
        lottos.add(new Lotto(Arrays.asList(1,2,3,4,5,10))); //3등
        lottos.add(new Lotto(Arrays.asList(1,2,3,4,11,10))); //4등
        lottos.add(new Lotto(Arrays.asList(1,2,3,12,11,10))); //5등
        lottos.add(new Lotto(Arrays.asList(1,2,13,12,11,10))); //탈락
        //lottos.add(new Lotto(Arrays.asList(1,2,3,4,10,7))); //2등
        List<Integer> answer = List.of(2_031_555_000,1,1,1,1,1);
        assertThat(2_031_555_000).isEqualTo(ResultCalculate.synthesizeRanking(lottos,numbers).get(0));
        assertThat(true)
                .isEqualTo(ResultCalculate.synthesizeRanking(lottos,numbers).equals(answer));
    }
}