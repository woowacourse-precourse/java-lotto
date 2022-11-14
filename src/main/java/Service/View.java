package Service;

import camp.nextstep.edu.missionutils.Console;
import domain.Game;

import static Controller.mainController.*;
import static domain.Game.getLottoCount;

public class View {
    private static final String MESSAGE_WINNINGNUMBERS_INPUT_FORMAT = "당첨번호를 입력해주세요.";
    public static final String MESSAGE_BUYINGAMOUNT_INPUT_FORMAT = "구입 금액을 입력해주세요";
    public static final String MESSAGE_BONUSNUMBER_INPUT_FORMAT = "보너스 번호를 입력해주세요";
    public static final String MESSAGE_ERROR_FORMAT="[ERROR]";
    public static final String MESSAGE_THREEHIT_FORMAT="3개 일치 (5,000원) - " +fifth_count + "개";
    public static final String MESSAGE_FOURHIT_FORMAT="4개 일치 (50,000원) - "+ +fourth_count + "개";
    public static final String MESSAGE_FIVEHIT_FORMAT="5개 일치 (1,500,000원) - "+ third_count + "개";
    public static final String MESSAGE_FIVE_AND_BONUHIT_FORMAT="5개 일치, 보너스 볼 일치 (30,000,000원) - "+ second_count + "개";
    public static final String MESSAGE_SIX_FORMAT="6개 일치 (2,000,000,000원) - "+ first_count + "개";
    public static final String MESSAGE_LOTTONUMBER_FORMAT=getLottoCount() + "개를 구매했습니다." +"\n";
    public static final String MESSAGE_STACTISTICS_FORMAT="당첨 통계";
    public static final String MESSAGE_TOTALGAIN_FORMAT="총 수익률은 " + get_stactiscs() +"%입니다.";
    public static final boolean

    public static String read_WinningNumbers() {
        System.out.print(MESSAGE_WINNINGNUMBERS_INPUT_FORMAT);
        Game.winningNumbers_Input = Console.readLine();
        return Game.winningNumbers_Input;
    }

    public static void read_buyingLottoAmount() {
        System.out.print(MESSAGE_BUYINGAMOUNT_INPUT_FORMAT + "\n");
        String Amount = Console.readLine();
        if (!Amount.matches("[0-9]*$")) {
            System.out.print(MESSAGE_ERROR_FORMAT);
            return;
        }
         Game.paymentAmount = Integer.parseInt(Amount);
        if (Game.paymentAmount % Game.LottoPrice != 0) throw new IllegalArgumentException();
    }
    public static void read_bonusNumber() {
        System.out.print(MESSAGE_BONUSNUMBER_INPUT_FORMAT + "\n");
        Game.bonusNumber = Integer.parseInt(Console.readLine());
    }
    public static void print_Stactistics() {
        System.out.println(MESSAGE_THREEHIT_FORMAT);
        System.out.println( MESSAGE_FOURHIT_FORMAT);
        System.out.println(MESSAGE_FIVE_AND_BONUHIT_FORMAT);
        System.out.println(MESSAGE_FIVE_AND_BONUHIT_FORMAT);
        System.out.println(MESSAGE_SIX_FORMAT);
    }
    public static void print_LottoNumber(){
        System.out.print(MESSAGE_LOTTONUMBER_FORMAT);
    }
    public static void print_Message_Stastistics(){
        System.out.print(MESSAGE_STACTISTICS_FORMAT);
    }
    public static void print_totalGain(){
        System.out.print(MESSAGE_TOTALGAIN_FORMAT);
    }

}
