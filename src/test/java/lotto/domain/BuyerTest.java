package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BuyerTest {
    private Buyer buyer;
    
    @BeforeEach
    void setUp() {
        buyer = new Buyer();
    }
    
    @DisplayName("오름차순 정렬을 확인한다.")
    @Test
    void sortLotto_테스트() {
        List<Integer> lotto = new ArrayList<Integer>(List.of(6,5,4,3,2,1));
        buyer.sortLotto(lotto);
        
        for (int index = 0; index < lotto.size(); index++) {
            assertThat(lotto.get(index)).isEqualTo(index + 1);
        }
        
    }
}
