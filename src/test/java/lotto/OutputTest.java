package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import controller.InputController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class OutputTest extends NsTest {


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
