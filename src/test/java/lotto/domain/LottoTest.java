package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("로또 번호를 배열 형태의 문자열로 반환한다.")
    @Test
    void getPrintByNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>(List.of(1, 2, 4, 3, 5, 6));
        
        assertThat(new Lotto(lottoNumbers).getStringByNumbers())
                .isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
    
    @DisplayName("로또 번호는 오름차순으로 정렬되어야 한다.")
    @Test
    void getNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>(List.of(6, 2, 3, 1, 4, 5));
        
        assertThat(new Lotto(lottoNumbers).getNumbers())
                .isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}
