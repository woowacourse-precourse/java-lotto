package lotto;

import lotto.domain.Controller;
import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.model.Prize;
import lotto.model.User;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class ControllerTest extends NsTest{

    @Override
    protected void runMain() {

    }

    Controller controller=new Controller();


    @DisplayName("당첨결과가 양식에 맞게 잘 나오는지 확인")
    @Test
    void checkPrintResultByFormat(){
        controller.winResult=new HashMap<>();
        for(Prize prize:Prize.values()){
            controller.winResult.put(prize,1);
        }
        controller.printAllPrizeNumber();
        assertThat(output()).contains(
                "3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 1개",
                "5개 일치 (1,500,000원) - 1개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                "6개 일치 (2,000,000,000원) - 1개");
    }

}
