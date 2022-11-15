package domain;

import controller.Controller;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoCompanyTest {

    private static Controller controller;
    @BeforeAll
    private static void init(){
        controller = new Controller();
    }

    @DisplayName("Bonus 숫자가 1 ~ 45 사이에 없으면 예외처리한다.")
    @Test
    void checkInputMoneyUnit(){
        assertThatThrownBy(() -> new LottoCompany(List.of(1,2,3,4,5,6), 47)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 길이가 6 이상일 경우 예외처리한다.")
    @Test
    void createWinningOverSize(){
        assertThatThrownBy(() -> new LottoCompany(List.of(1,2,3,4,5,6,7), 20)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호기 중복되면 예외처리 한다.")
    @Test
    void createWinningDuplicate(){
        assertThatThrownBy(() -> new LottoCompany(List.of(1,2,3,4,5,5), 20)).isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("당첨 번호가 1 ~ 45 범위가 넘어갈 경우 예외처리 한다.")
    @Test
    void createWinningOverRange(){
        assertThatThrownBy(() -> new LottoCompany(List.of(1,2,3,4,5,77), 20)).isInstanceOf(IllegalArgumentException.class);
    }
}