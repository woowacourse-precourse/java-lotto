package lotto.domain.winning;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumberComparatorTest {
    
    WinningNumberComparator lottoNumberComparator;
    
    @BeforeEach
    void setUp() {
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6), List.of(7));
        lottoNumberComparator = new WinningNumberComparator(winningNumber);
    }
    
    @DisplayName("당첨 번호를 갖는 로또 인스턴스를 비교 메소드로 실행했을 때 당첨 내역을 반환해야 한다.")
    @Test
    void compareByWinningNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(lottoNumbers);
        Optional<WinningDetail> optionalWinningDetail = lottoNumberComparator.compare(lotto);
        
        assertThat(optionalWinningDetail).isNotEmpty();
    }
    
    @DisplayName("당첨 번호가 아닌 로또 인스턴스를 비교 메소드로 실행했을 때 Empty를 반환해야 한다.")
    @Test
    void compareByNotWinningNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>(List.of(7, 12, 25, 34, 37, 45));
        Lotto lotto = new Lotto(lottoNumbers);
        Optional<WinningDetail> optionalWinningDetail = lottoNumberComparator.compare(lotto);
        
        assertThat(optionalWinningDetail).isEmpty();
    }
}
