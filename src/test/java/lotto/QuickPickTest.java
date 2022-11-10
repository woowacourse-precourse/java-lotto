package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QuickPickTest {
    private List<Integer> quickPickNumbers = QuickPick.create();
    @DisplayName("로또 번호의 개수는 6개이다.")
    @Test
    void isNumberLengthSix(){
        assertThat(quickPickNumbers.size()).isEqualTo(6);
    }
    @DisplayName("번호가 1~45 범위 안이다.")
    @Test
    void inBoundary(){
        for(int number : quickPickNumbers){
            assertThat(number).isBetween(1,45);
        }
    }
    @DisplayName("번호에 중복이 없다.")
    @Test
    void nonDuplicated(){
        Set<Integer> quickPickNumberSet = new HashSet<>(quickPickNumbers);
        assertThat(quickPickNumbers.size()).isEqualTo(quickPickNumberSet.size());
    }
}
