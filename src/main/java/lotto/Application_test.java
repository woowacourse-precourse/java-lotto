package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Application_test {

        Application A;

        @BeforeEach
        void Setup() {
            A = new Application();
        }
        List<Integer> Answer_Number = List.of(1,2,3,4,5,6);
        Integer Bonus_Number = 7;
        List<Integer> Lotto_numbers = List.of(1,2,3,10,11,12);



        @Test
        void Answer_test() {
            Integer result = A.Lotto_machine( Answer_Number, Bonus_Number, Lotto_numbers);

            assertThat(result).isEqualTo(3);
        }
    }

