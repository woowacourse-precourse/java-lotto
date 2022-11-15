package lotto;

import lotto.domain.Controller;
import lotto.utils.Logger;
import lotto.utils.Logger.LogType;

public class Application {
    public static void main(String[] args) {
        Config.validate();
        Controller gameController = Controller.getInstance();
        try {
            gameController.run();
        }catch (IllegalArgumentException e){
            Logger.log(e.getMessage(), LogType.ERROR);
        }
    }
}
