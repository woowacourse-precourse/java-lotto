package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WinningPlaceTest {

    @DisplayName("번호 일치에 대한 결과값 반환에서 예외가 발생한다.")
    @Test
    public void getWinningMessageTest() throws Exception {
        //given
        String expectedMessage = "6개 번호 일치";
        WinningPlace winningPlace = WinningPlace.FIRST_PLACE;
        //when
        String actualMessage = WinningPlace.FIRST_PLACE.getMessage();

        //then
        assertEquals(expectedMessage, actualMessage);
    }

    @DisplayName("주어진 일치 번호 갯수와 보너스 번호 일치 여부로 순위를 반환한다.")
    @Test
    public void getPlaceTest() throws Exception {
        //given
        int correspondingNumber = 6;
        int correspondingBonusNumber = 0;
        WinningPlace expectedPlace = WinningPlace.FIRST_PLACE;
        //when
        WinningPlace actualPlace = WinningPlace.getPlace(correspondingNumber, correspondingBonusNumber);

        //then
        assertEquals(expectedPlace, actualPlace);
    }

    @DisplayName("당첨 금액이 정상적 반환이 되는지 여부 확인")
    @Test
    public void getWinningsTest() throws Exception{
        //given
        WinningPlace winningPlace = WinningPlace.FIRST_PLACE;
        int expectedValue = 2000000000;
        //when
        Integer actualValue = winningPlace.getWinnings();

        //then
        assertEquals(expectedValue, actualValue);

    }
}