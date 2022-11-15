package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class SaturdayTest {
    Saturday saturday;
    SaturdayTest(){
        saturday = new Saturday("1,2,3,4,5,6","7");
        DB.insert(new Lotto(List.of(8, 21, 23, 41, 42, 43)));
        DB.insert(new Lotto(List.of(3, 5, 11, 16, 32, 38)));
        DB.insert(new Lotto(List.of(7, 11, 16, 35, 36, 44)));
        DB.insert(new Lotto(List.of(1, 8, 11, 31, 41, 42)));
        DB.insert(new Lotto(List.of(13, 14, 16, 38, 42, 45)));
        DB.insert(new Lotto(List.of(7, 11, 30, 40, 42, 43)));
        DB.insert(new Lotto(List.of(2, 13, 22, 32, 38, 45)));
        DB.insert(new Lotto(List.of(1, 3, 5, 14, 22, 45)));
        saturday.makeStatistics();
        saturday.calYeild();
    }
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
        assertThat(saturday.checkNumber(3)).isEqualTo(true);
        DB.init();
    }

    @Test
    void testCheckNumberFalse(){
        assertThat(saturday.checkNumber(8)).isEqualTo(false);
        DB.init();
    }

    @Test
    void testCheckLotto(){
        assertThat(saturday.checkLottoAt(7)).isEqualTo(3);
        DB.init();
    }

    @Test
    void testmakeStatistics(){
        assertThat(DB.getStatistics()).isEqualTo(new ArrayList<Integer>(List.of(1,0,0,0,0)));
        DB.init();
    }

    @Test
    void testPrize(){
        assertThat(DB.getPrizeSum()).isEqualTo(5000);
        DB.init();
    }

    @Test
    void testmakeStatisticsYeild(){
        assertThat(DB.getYeild()).isEqualTo(62.5);
        DB.init();
    }



}
