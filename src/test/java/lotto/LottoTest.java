package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능

    //예외 처리 테스트
    @DisplayName("예외 처리 에러가 IllegalArgumentException 인지 확인하는 테스트")
    @Test
    void exceptionsTest(){
        assertThatThrownBy(()->new Exceptions())
                .isInstanceOf(IllegalArgumentException.class);
    }

    //구매 가격 입력 테스트
    @DisplayName("구매 가격에 문자가 있으면 예외가 발생한다.")
    @Test
    void createLottoString() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new BuyPrice("1500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 가격을 제대로 입력받으면 몇장의 로또를 살 수 있는지 확인하는 코드")
    @Test
    void checkTheCorrectPriceReturn(){
        BuyPrice buyPrice = new BuyPrice("3000");
        int buy__ = buyPrice.checkPrice();
        int expectedReturn = 3;
        assertThat(buy__).isEqualTo(expectedReturn);
    }


    // 로또 번호 생성 관련 테스트
    @DisplayName("로또 번호 생성 테스트")
    @Test
    void checkTheTicket(){
        TicketNumbers ticketNumbers = new TicketNumbers(3);
        ticketNumbers.collectTickets();
    }

}
