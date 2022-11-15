package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class SaturdayTest {

    @DisplayName("입력받은 값이 정규식과 다를때 Exception 발생")
    @Test
    void testValidateStrInput(){
        assertThatThrownBy(() -> new Saturday("1,2,3,4,5,6,7","3"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Saturday("WangJunYoung is Best Developer","3"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Saturday("1,2,3,4,5,6","0"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Saturday("1,2,3,4,5,6","100"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Saturday("1,2,3,4,5,6","I Love Woowacourse"))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("입력받은 값의 오류가 있을때 Exception 발생")
    @Test
    void testValidateIntInput(){
        //45를 넘는 수 입력
        assertThatThrownBy(() -> new Saturday("46,55,77,4,3,2","3"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Saturday("1,2,3,4,5,6","46"))
                .isInstanceOf(IllegalArgumentException.class);

        //bonus와 win 에 포함되어 있을때
        assertThatThrownBy(() -> new Saturday("1,2,3,4,5,6","6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testCheckNumberTrue(){
        Saturday saturday = new Saturday("1,2,3,4,5,6","7");
        DB.insert(new Lotto(List.of(1,2,3,4,5,6)));
        assertThat(saturday.checkNumber(3)).isEqualTo(true);
    }
    @Test
    void testCheckNumberFalse(){
        Saturday saturday = new Saturday("1,2,3,4,5,6","7");
        DB.insert(new Lotto(List.of(1,2,3,4,5,6)));
        assertThat(saturday.checkNumber(8)).isEqualTo(false);
    }
    @Test
    void testCheckLotto(){
        Saturday saturday = new Saturday("1,2,3,4,5,6","7");
        DB.insert(new Lotto(List.of(1,2,3,7,10,45)));
        DB.insert(new Lotto(List.of(1,2,3,4,5,7)));
        DB.insert(new Lotto(List.of(1,2,3,4,7,10)));
        DB.insert(new Lotto(List.of(1,2,3,4,5,11)));
        DB.insert(new Lotto(List.of(1,2,3,4,5,6)));

        assertThat(saturday.checkLottoAt(0)).isEqualTo(4);
        assertThat(saturday.checkLottoAt(1)).isEqualTo(50);
        assertThat(saturday.checkLottoAt(2)).isEqualTo(5);
        assertThat(saturday.checkLottoAt(3)).isEqualTo(5);
        assertThat(saturday.checkLottoAt(4)).isEqualTo(6);
    }

    @Test
    void testmakeStatistics(){
        Saturday saturday = new Saturday("1,2,3,4,5,6","7");
        DB.insert(new Lotto(List.of(1,2,3,4,5,6))); //6
        DB.insert(new Lotto(List.of(1,2,3,4,5,7))); // 5+b
        DB.insert(new Lotto(List.of(1,2,3,4,7,10))); // 5
        DB.insert(new Lotto(List.of(1,2,3,4,11,45))); //4

        assertThat(saturday.makeStatistics()).isEqualTo(List.of(0,1,1,1,1));

    }


}
