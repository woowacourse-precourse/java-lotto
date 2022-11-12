package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.exception.InputException;

public class InputView {
    private final static String NUMBER_OF_PRICE = "구입금액을 입력해 주세요.";
    private final static String NUMBER_OF_LOTTO = "당첨 번호를 입력해 주세요.";
    private final static String NUMBER_OF_BONUSNUMBER = "보너스 번호를 입력해 주세요";

    public static int getInputPrice(){
        while(true){
            try{
                System.out.println(NUMBER_OF_PRICE);
                return InputException.isValidInputPrice(Console.readLine());
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static WinningLotto getInputWinningLotto(){
        while(true){
            try{
                System.out.println(NUMBER_OF_LOTTO);
                Lotto winningNumber = InputException.isValidLottoNumber(Console.readLine());

                System.out.println(NUMBER_OF_BONUSNUMBER);
                int bonusNumber = InputException.isValidBonusNumber(Console.readLine());

                return InputException.isValidWinningLotto(winningNumber, bonusNumber);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }



}
