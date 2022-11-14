package lotto;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Application {


    public static void main(String[] args) {
        UI ui = new UI();
        ui.inputCost();

        User user = new User(ui.getCost());

    }
}
