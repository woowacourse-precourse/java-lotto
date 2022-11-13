package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TooManyListenersException;

public class I_O_System {
    public static final String BAGIC_ERROR_MESSAGE = "[ERROR]";
    private static final String Sell_Messge = "개를 구매했습니다.";
    private static final String User_Number_Answer = "당첨 번호를 입력해 주세요.";
    private static final String Bonus_Number_Answer = "보너스 번호를 입력해 주세요.";
    private static final String ERROR_Code_1 = " 숫자가 아닌 문자가 들어왔습니다.";
    private static final String ERROR_Code_2 = " 돈이 천원 단위로 나누어지지않습니다.";

    private static final int Lottey_min = 1;
    private static final int Lottey_max = 6;
    private static final int Lottey_number_max = 45;
    static final int lottey_price = 1000;

    private String Enter_Number = "0";
    private int Money_Enter = 0;
    private int Ticket = 0;

    public boolean Enter_Price() {
        Enter_Number = Console.readLine();
        if (!Differnet_Error()) {
            return false;
        }
        Money_Enter = Integer.parseInt(Enter_Number);
        if (!left_money()) {
            return false;
        }
        Ticket = Money_Enter / lottey_price;
        return true;
    }

    public void Lottey_System() {
        int Bonus_Number = 0;
        List<Integer> Winning_Number = new ArrayList<>();
        List<List<Integer>> mylist = new ArrayList<>();

        User_Lottery_Number(mylist);
        Enter_WinningNumber(Winning_Number);
        Bonus_Number = Bonus_Number_Enter(Bonus_Number);
    }

    private boolean Differnet_Error() {
        try {
            if (!(Enter_Number != null && Enter_Number.matches("^[0-9]*$"))) {
                throw new IllegalArgumentException(BAGIC_ERROR_MESSAGE + ERROR_Code_1);
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return false;

        }
        return true;
    }

    private boolean left_money() {
        int Base_Number = 0;

        try {
            if ((Base_Number = Money_Enter % 1000) > 0) {
                throw new IllegalArgumentException(BAGIC_ERROR_MESSAGE + ERROR_Code_2);
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return false;
        }

        return true;
    }

    public void Enter_WinningNumber(List<Integer> Winning_Number) {
        System.out.println(User_Number_Answer);
        Enter_Number = Console.readLine();

        String[] arrayIn = Enter_Number.split(",");
        for (int i = 0; i < arrayIn.length; i++) {
            Winning_Number.add(Integer.parseInt(arrayIn[i]));
        }
        Lotto lotto = new Lotto(Winning_Number);
    }

    public void User_Lottery_Number(List<List<Integer>> mylist) {
        System.out.println(Ticket + Sell_Messge);
        for (int i = 0; i < Ticket; i++) {
            List<Integer> number = Randoms.pickUniqueNumbersInRange(Lottey_min, Lottey_number_max, Lottey_max);
            Lotto lotto = new Lotto(number);
            Ticket_Print(number);
            mylist.add(number);
        }
    }

    private int Bonus_Number_Enter(int Bonus_Number) {
        System.out.println(Bonus_Number_Answer);
        Enter_Number = Console.readLine();
        Bonus_Number = Integer.parseInt(Enter_Number);

        return Bonus_Number;
    }

    public void Ticket_Print(List<Integer> number) {
        List<Integer> Print_Number = new ArrayList<>();

        Print_Number.addAll(number);
        Collections.sort(Print_Number);
        System.out.println(Print_Number);
    }


}
