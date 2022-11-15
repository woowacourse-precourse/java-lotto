package lotto.domain;

import org.junit.jupiter.api.BeforeEach;

class LottoResultTest {

    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult();
        lottoResult.add(LottoRank.THIRD);
        lottoResult.add(LottoRank.THIRD);
    }

}