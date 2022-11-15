package lotto.controller;

import lotto.view.Input;
import lotto.view.Output;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("로또 컨트롤러 객체가 제대로 생성이 되는지 확인")
class LottoControllerTest {

    static LottoController controller;
    static String lottoControllerName = "lotto.controller.LottoController";

    @BeforeAll
    public static void beforeAll(){
        controller = new LottoController(new Input(), new Output());
    }

    @DisplayName("LottoController 객체가 생성이 되어야 한다.")
    @Test
    public void testLottoController(){
        assertThat(controller.getClass().getName()).isEqualTo(lottoControllerName);
    }

    @AfterAll
    public static void afterAll(){
        controller = null;
    }
}