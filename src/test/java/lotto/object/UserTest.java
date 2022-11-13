package lotto.object;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.playlotto.object.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UserTest extends NsTest {

    @DisplayName("사용자에게 돈을 입력 받고 로또 번호까지 생성한다.")
    @Test
    void pay_Money_And_Create_Lottery_nums() {
            assertRandomUniqueNumbersInRangeTest(
                    () -> {
                        run("6000");
                        assertThat(output()).contains(
                                "6",
                                "[8, 21, 23, 41, 42, 43]",
                                "[3, 5, 11, 16, 32, 38]",
                                "[7, 11, 16, 35, 36, 44]",
                                "[1, 8, 11, 31, 41, 42]",
                                "[13, 14, 16, 38, 42, 45]",
                                "[7, 11, 30, 40, 42, 43]"
                                );
                    },
                    List.of(8, 21, 23, 41, 42, 43),
                    List.of(3, 5, 11, 16, 32, 38),
                    List.of(7, 11, 16, 35, 36, 44),
                    List.of(1, 8, 11, 31, 41, 42),
                    List.of(13, 14, 16, 38, 42, 45),
                    List.of(7, 11, 30, 40, 42, 43)
            );
    }


    @DisplayName("유저가 금액을 지불했을 때 복권의 갯수가 몇개인지 확인")
    @Test
    void create_Lottery_nums() {
        User user = new User();
        user.setLottery_count(6);
        user.create_Lottery_nums();
        assertThat(user.getLottery_nums().size()).isEqualTo(6);
    }

    @Override
    protected void runMain() {
        User.main(new String[]{});
    }
}