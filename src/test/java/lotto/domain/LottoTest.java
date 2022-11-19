package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @Test
    @DisplayName("숫자의 길이가 6이 아닌경우 예외 발생")
    void lengthError(){
        assertThrows(IllegalArgumentException.class, () ->{

            new Lotto(List.of(1,2,3,4,5,6,7));
        });

        assertThrows(IllegalArgumentException.class, () ->{
            new Lotto(List.of(1));
        });
    }

    @Test
    @DisplayName("숫자의 범위가 1~45이하가 아닌 경우 예외 발생")
    void inCorrectRangeError(){
        assertThrows(IllegalArgumentException.class, () ->{
            new Lotto(List.of(1,2,3,4,5,46));
        });

        assertThrows(IllegalArgumentException.class, () ->{
            new Lotto(List.of(0,1,2,3,4,5));
        });
    }

    @Test
    @DisplayName("중복되는 수가 있을 경우 예외 발생")
    void duplicationError(){
        assertThrows(IllegalArgumentException.class, () ->{
            new Lotto(List.of(1,1,2,3,4,5));
        });

    }

    @Test
    @DisplayName("보너스 숫자를 포함할 경우 예외 발생")
    void containBonusNumError(){
        assertThrows(IllegalArgumentException.class, () ->{
            new Lotto(List.of(1,2,3,4,5,6),6);
        });
    }

}