package lotto.model.computer.repository;

import java.util.ArrayList;
import lotto.model.computer.lottonumber.LottoLine;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoRepositoryTest {

    LottoRepository lottoRepository;

    @BeforeEach
    void setLottoRepository() {
        lottoRepository = new LottoRepository();
    }

    @Test
    void LottoRepository_저장_후_사이즈_확인() {
        int result = 64;
        for (int i = 0; i < 64; i++) {
            lottoRepository.saveLotto(new LottoLine(new ArrayList<>()));
        }
        Assertions.assertThat(lottoRepository.sizeOfLotto()).isEqualTo(result);
    }
}