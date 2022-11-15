package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/*
 * 당첨 번호 입력 프롬프트 출력 및 입력 수행
 */
public class LottoConsoleTest {

    @Test
    @DisplayName("로또 구매 금액 입력 프롬프트 출력")
    public void promptAskBuyingMessage() {
        final var sut = new LottoConsole();

        final String buyingAskMessage = sut.buyingAskMessage();

        assertEquals("구입금액을 입력해 주세요.", buyingAskMessage);
    }

    @Test
    @DisplayName("로또 구매 금액 개수 및 로또 번호 출력")
    public void promptBoughtLottoMessage() {
        final var sut = new LottoConsole();
        final var firstOne = Arrays.asList(1, 2, 3, 4, 5, 6);
        final var secondOne = Arrays.asList(1, 2, 3, 4, 5, 6);
        final var thirdOne = Arrays.asList(1, 2, 3, 4, 5, 6);
        final var lottos = Arrays.asList(firstOne, secondOne, thirdOne);

        final String buoughtLottoMessage = sut.boughtLottoMessage(lottos);

        assertEquals(
            "3개를 구매했습니다.\n[1, 2, 3, 4, 5, 6]\n[1, 2, 3, 4, 5, 6]\n[1, 2, 3, 4, 5, 6]",
            buoughtLottoMessage
        );
    }
}
