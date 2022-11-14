package view;

import camp.nextstep.edu.missionutils.Console;
import domain.Lotto;
import java.util.ArrayList;
import java.util.List;
import util.ValidateWinningLottoNumber;

public class InputWinningLottoNumber {


    static List<Integer> winningLottoTicket = new ArrayList<>();

    public static void inputWinningLottoNumber() {
        OutputView.printInputLotto();
        String Lotto = Console.readLine();
        winningLottoTicket = ValidateWinningLottoNumber.setWinningLottoTicket(Lotto);
        Lotto lotto = new Lotto(winningLottoTicket);
    }


    public static List<Integer> getWinningLottoTicket() {
        return winningLottoTicket;
    }

}
