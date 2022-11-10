package lotto;

import camp.nextstep.edu.missionutils.Console;
import input.CashReader;
import print.Printer;
import java.util.List;
import java.util.ArrayList;

public class LottoMachine {
    Printer printer = new Printer();
    List<Lotto> lottos = new ArrayList<>();
    public void start(){
        String rawMoney = Console.readLine();
        CashReader cashReader = new CashReader(Integer.parseInt(rawMoney));
        lottos = cashReader.publishLotto();
    }
}
