package view;

import camp.nextstep.edu.missionutils.Console;
import util.Lotto;
import java.util.ArrayList;
import java.util.List;
import util.ConvertWinningLottoNumber;

public class InputWinningLottoNumber {


    static List<Integer> winningLottoTicket = new ArrayList<>();

    public static void inputWinningLottoNumber() {
        OutputView.printInputLotto();
        String Lotto = Console.readLine();
        winningLottoTicket = ConvertWinningLottoNumber.setWinningLottoTicket(Lotto);
        Lotto lotto = new Lotto(winningLottoTicket);

    }


    public static List<Integer> getWinningLottoTicket() {
        return winningLottoTicket;
    }

}
