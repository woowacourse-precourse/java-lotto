package lotto;

import static org.assertj.core.api.Assertions.assertThat;

class PurchaseLottoTest {
    /**
     * input값을 따로 지정해주는 경우
     *
    @Test
    void inputParchaseMeony_Test() {
        ParchaseLotto parchaseLotto = new ParchaseLotto();
        assertEquals(parchaseLotto.inputParchaseMeony("3000"),3);
        assertThrows(IllegalArgumentException.class,()->{
            parchaseLotto.inputParchaseMeony("ab10");
        });
        assertThrows(IllegalArgumentException.class,()->{
            parchaseLotto.inputParchaseMeony("12345");
        });
    }
    */
}