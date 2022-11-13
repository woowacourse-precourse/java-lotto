package lotto.system;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class SettlementSystemTest {
    private SettlementSystem settlementSystem;


 /*   @BeforeEach
    void setUp() {
        this.settlementSystem = new SettlementSystem();
    }

    @AfterEach
    void tearDown() {
        this.settlementSystem = null;
    }*/

    /*@Test
    void 로또묶음과_당첨로또를_비교했을때_결과값을_만들어냅니다() {
        var bundle = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 7)
        );
        LottoBundle lottoBundle = new LottoBundle(bundle);
        AnswerLotto answerLotto = new AnswerLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new LottoNumber(7));
        System.out.println(this.settlementSystem.result(lottoBundle, answerLotto));
    }*/
}