package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WinningPlaceTest {

    @DisplayName("번호 일치에 대한 결과값 반환에서 예외가 발생한다.")
    @Test
    public void getWinningMessageTest() {
        //given
        LottoRank lottoRank = LottoRank.FIRST_PLACE;
        String expectedMessage = "6개 일치 (2,000,000,000원) - ";
        //when
        String actualMessage = lottoRank.getMessage();

        //then
        assertEquals(expectedMessage, actualMessage);
    }

    @DisplayName("주어진 일치 번호 갯수와 보너스 번호 일치 여부로 순위를 반환한다.")
    @Test
    public void getPlaceTest() {
        //given
        int correspondingNumber = 6;
        int correspondingBonusNumber = 0;
        LottoRank expectedPlace = LottoRank.FIRST_PLACE;
        //when
        LottoRank actualPlace = LottoRank.getRank(correspondingNumber, correspondingBonusNumber);

        //then
        assertEquals(expectedPlace, actualPlace);
    }

    @DisplayName("순위에 없는 경우에는 NOT_IN_PLACE를 반환해야 한다.")
    @Test
    public void getPlaceTest_ExceptionCasa() {
        //given
        int correspondingNumber = 0;
        int correspondingBonusNumber = 0;
        LottoRank expectedPlace = LottoRank.NOT_IN_PLACE;
        //when
        LottoRank actualPlace = LottoRank.getRank(correspondingNumber, correspondingBonusNumber);

        //then
        assertEquals(expectedPlace, actualPlace);
    }

    @DisplayName("당첨 금액이 정상적 반환이 되는지 여부 확인")
    @Test
    public void getWinningsTest() {
        //given
        LottoRank lottoRank = LottoRank.FIRST_PLACE;
        int expectedValue = 2000000000;
        //when
        Integer actualValue = lottoRank.getWinnings();

        //then
        assertEquals(expectedValue, actualValue);

    }
}