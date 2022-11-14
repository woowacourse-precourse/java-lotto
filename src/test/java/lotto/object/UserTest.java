package lotto.object;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.playlotto.object.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UserTest {
    @DisplayName("유저가 금액을 지불했을 때 복권의 갯수가 몇개인지 확인")
    @Test
    void create_Lottery_nums() {
        User user = new User();
        user.setLottery_count(6);
        user.create_Lottery_nums();
        assertThat(user.getLottery_nums().size()).isEqualTo(6);
    }


}