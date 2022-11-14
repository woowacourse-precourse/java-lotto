package lotto;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.*;

class UserTest {
    @DisplayName("사용자가 구매한 금액이 1000원 단위가 아닌 경우 에러 발생")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new User(4200))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("사용자가 구매한 로또 개수 테스트")
    @Test
    void getPurchasLottoCount(){
        User user = new User(4000);

        //1등 테스트
        assertThat(user.getUserLottos().size())
                .isEqualTo(4);
    }

    @DisplayName("사용자의 당청 통계 계산 테스트")
    @Test
    void getCountRanking(){
        User user = new User(6000);

        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6),7);
        user.setUserLottos(List.of(
                List.of(1,2,3,4,5,6),
                List.of(1,2,3,4,5,6),
                List.of(2,3,4,5,6,7),
                List.of(4,5,6,7,8,9),
                List.of(1,2,3,7,8,9),
                List.of(9,10,11,12,13,14)
        ));

        user.setCountRanking(lotto);

        int i = 0;
        int[] countArray = {2,1,0,0,2};
        for(LottoRanking lottoRanking : LottoRanking.values()){
            assertThat(user.getCountRanking().get(lottoRanking))
                    .isEqualTo(countArray[i]);
            i+=1;
        }
    }

    @DisplayName("수익률 계산 테스트")
    @Test
    void getRateOfReturn() {
        User user = new User(6000);

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6), 7);
        user.setUserLottos(List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(2, 3, 4, 5, 6, 7),
                List.of(4, 5, 6, 7, 8, 9),
                List.of(1, 2, 3, 7, 8, 9),
                List.of(9, 10, 11, 12, 13, 14)
        ));

        user.setCountRanking(lotto);
        BigDecimal expected = new BigDecimal("67166733.33");
        assertThat(user.caculateRateOfReturn()).isEqualTo(expected);


    }
}
