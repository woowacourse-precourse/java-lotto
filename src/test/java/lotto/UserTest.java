package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.InstanceOfAssertFactories.ARRAY;
import static org.assertj.core.api.InstanceOfAssertFactories.LIST;
import static org.assertj.core.api.InstanceOfAssertFactories.array;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

class UserTest {
    @Test
     void 로또_구입_금액_입력(){
        int answer = 14000;
        String userInput = "14000";

        ByteArrayInputStream input = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(input);

        User user = new User();
        user.setPurchasePrice();

        assertThat(user.purchasePrice).isEqualTo(answer);
    }

    @Test
    void 로또_구입_금액_예외처리(){
        String userInput = "14500";

        ByteArrayInputStream input = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(input);

        User user = new User();
        assertThatThrownBy(() -> user.setPurchasePrice()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호_입력(){
        List<Integer> answer = List.of(1,2,3,4,5,6);
        String userInput = "1,2,3,4,5,6";

        ByteArrayInputStream input = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(input);

        User user = new User();
        user.setWinningNumbers();

        assertThat(user.winningNumbers).isEqualTo(answer);
    }

    @Test
    void 당첨_번호_예외처리1(){
        String userInput = "1,2,3,4,5,6,7";

        ByteArrayInputStream input = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(input);

        User user = new User();
        assertThatThrownBy(() -> user.setWinningNumbers()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호_예외처리2(){
        String userInput = "1,2,3,4,5";

        ByteArrayInputStream input = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(input);

        User user = new User();
        assertThatThrownBy(() -> user.setWinningNumbers()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호_예외처리3(){
        String userInput = "1,2,3,4,5,a";

        ByteArrayInputStream input = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(input);

        User user = new User();
        assertThatThrownBy(() -> user.setWinningNumbers()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호_입력(){
        int answer = 7;
        String userInput = "7";

        ByteArrayInputStream input = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(input);

        User user = new User();
        user.setBonusNumber();

        assertThat(user.bonusNumber).isEqualTo(answer);
    }

    @Test
    void 보너스_번호_예외처리(){
        String userInput = "a";

        ByteArrayInputStream input = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(input);

        User user = new User();
        assertThatThrownBy(() -> user.setBonusNumber()).isInstanceOf(IllegalArgumentException.class);
    }
}