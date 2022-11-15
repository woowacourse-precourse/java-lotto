package factory;

import controller.impl.LottoGameController;
import util.Inputer;
import util.Printer;
import util.impl.LottoNumberComparator;

public class LottoGameFactory {
    public static LottoGameController getGame(){
        return new LottoGameController(new Inputer(), new LottoNumberComparator(), new Printer());
    }

}
