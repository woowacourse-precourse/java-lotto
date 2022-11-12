package view;

import camp.nextstep.edu.missionutils.Console;
import constant.ErrorMessage;
import domain.Lotto;
import java.util.ArrayList;
import java.util.List;
import util.ValidateWinningLottoNumber;

public class InputWinningLottoNumber {


    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER =1;
    private static final int TICKET_SIZE=6;
    static List<Integer> winningLottoTicket = new ArrayList<>();

    public static void inputWinningLottoNumber(){
        OutputView.printInputLotto();
        String Lotto = Console.readLine();
        winningLottoTicket = ValidateWinningLottoNumber.setWinningLottoTicket(Lotto);
        Lotto lotto = new Lotto(winningLottoTicket);
    }



    public static List<Integer> getWinningLottoTicket() {
        return winningLottoTicket;
    }

}
