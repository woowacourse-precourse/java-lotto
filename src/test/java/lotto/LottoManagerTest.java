package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoManagerTest {

    private LottoManager lottoManager;

    @BeforeEach
    void setUp() {
        lottoManager = new LottoManager();
    }

    @DisplayName("구입 금액만큼의 로또 발행 테스트")
    @Test
    void generateLottoTickets() {
        int purchasingAmount = 5000;

        lottoManager.generateLottoTickets(purchasingAmount);
        List<Lotto> lottoTickets = lottoManager.getLottoTickets();

        assertThat(lottoTickets.size()).isEqualTo(5);
    }

    @DisplayName("로또 숫자 생성 테스트")
    @Test
    void generateLottoNumbers() {
        List<Integer> lottoNumbers = lottoManager.generateLottoNumbers();
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }

}