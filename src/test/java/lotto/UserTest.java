package lotto;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


class UserTest {
    @Test
    void createLottoListTest() {
        List<Lotto> lottoList = User.createLottoList(12000);
        assertThat(lottoList.size()).isEqualTo(12);

        for(Lotto lotto : lottoList){
            List<Integer> numbers = lotto.getNumbers();

            //List 중복 검사
            HashSet<Integer> hashSet = new HashSet<>(numbers);
            assertThat(hashSet.size()).isEqualTo(6);

            //List 원소 범위 검사
            for(Integer number : numbers){
                assertThat(number).isGreaterThanOrEqualTo(1).isLessThanOrEqualTo(45);
            }
        }
    }
}