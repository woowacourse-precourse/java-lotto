package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BuyLottoTest {

    @DisplayName("구매한 로또가 오름차순으로 정렬되는지 테스트")
    @Test
    void lottoNumbersAscendingOrder(){

        List<Integer> lottoNumbers = List.of(6,5,4,3,2,1);

        assertThat(BuyLotto.sortingNumbers(lottoNumbers).equals(List.of(1,2,3,4,5,6)));
    }
}