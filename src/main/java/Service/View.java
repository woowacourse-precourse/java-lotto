package Service;

import camp.nextstep.edu.missionutils.Console;
import domain.Game;

import static Controller.mainController.*;
import static domain.Game.getLottoCount;

public class View {
    private static final String MESSAGE_WINNINGNUMBERS_INPUT_FORMAT = "당첨번호를 입력해주세요." + "\n";
    public static final String MESSAGE_BUYINGAMOUNT_INPUT_FORMAT = "구입 금액을 입력해주세요";
    public static final String MESSAGE_BONUSNUMBER_INPUT_FORMAT = "보너스 번호를 입력해주세요";
    public static final String MESSAGE_ERROR_FORMAT = "[ERROR]";
    public static final String MESSAGE_THREEHIT_FORMAT = "3개 일치 (5,000원) - ";
    public static final String MESSAGE_FOURHIT_FORMAT = "4개 일치 (50,000원) - ";
    public static final String MESSAGE_FIVEHIT_FORMAT = "5개 일치 (1,500,000원) - ";
    public static final String MESSAGE_FIVE_AND_BONUHIT_FORMAT = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    public static final String MESSAGE_SIX_FORMAT = "6개 일치 (2,000,000,000원) - ";
    public static final String MESSAGE_STACTISTICS_FORMAT = "당첨 통계" + "\n";
    public static final boolean NOT_DIVISON_AMOUNT = Game.paymentAmount % Game.LottoPrice != 0;

    public static String read_WinningNumbers() {
        System.out.print(MESSAGE_WINNINGNUMBERS_INPUT_FORMAT);
        Game.winningNumbers_Input = Console.readLine();
        return Game.winningNumbers_Input;
    }

    public static boolean read_buyingLottoAmount() {
        System.out.print(MESSAGE_BUYINGAMOUNT_INPUT_FORMAT + "\n");
        String Amount = Console.readLine();

        if (!Amount.matches("[0-9]*$")) {
            System.out.print(MESSAGE_ERROR_FORMAT);

            return true;
        }

        Game.paymentAmount = Integer.parseInt(Amount);
        if (NOT_DIVISON_AMOUNT) throw new IllegalArgumentException();
        return false;
    }

    public static void read_bonusNumber() {
        System.out.print(MESSAGE_BONUSNUMBER_INPUT_FORMAT + "\n");
        Game.bonusNumber = Integer.parseInt(Console.readLine());
    }

    public static void print_Stactistics() {
        System.out.println(MESSAGE_THREEHIT_FORMAT + fifth_count + "개");
        System.out.println(MESSAGE_FOURHIT_FORMAT + fourth_count + "개");
        System.out.println(MESSAGE_FIVEHIT_FORMAT + third_count + "개");
        System.out.println(MESSAGE_FIVE_AND_BONUHIT_FORMAT + second_count + "개");
        System.out.println(MESSAGE_SIX_FORMAT + first_count + "개");
    }

    public static void print_LottoNumber() {
        System.out.print(getLottoCount() + "개를 구매했습니다." + "\n");
    }

    public static void print_Message_Stastistics() {
        System.out.print(MESSAGE_STACTISTICS_FORMAT);
    }

    public static void print_totalGain() {
        System.out.print("총 수익률은 " + get_stactiscs() + "%입니다.");
    }

}
