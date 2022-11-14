package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class I_O_System {
    public static final String BAGIC_ERROR_MESSAGE = "[ERROR]";
    private static final String Sell_Messge = "개를 구매했습니다.";
    private static final String User_Number_Answer = "당첨 번호를 입력해 주세요.";
    private static final String Bonus_Number_Answer = "보너스 번호를 입력해 주세요.";
    private static final String ERROR_Code_1 = " 숫자가 아닌 문자가 들어왔습니다.";
    private static final String ERROR_Code_2 = " 돈이 천원 단위로 나누어지지않습니다.";
    private final String Three_Matche = "3개 일치 (5,000원) - ";
    private final String Four_Matche = "4개 일치 (50,000원) - ";
    private final String Five_Matche = "5개 일치 (1,500,000원) - ";
    private final String Five_Matche_Bounus = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private final String Six_Matche = "6개 일치 (2,000,000,000원) - ";
    private final String Point = "개";

    private static final int Lottey_min = 1;
    private static final int Lottey_max = 6;
    private static final int Lottey_number_max = 45;
    static final int lottey_price = 1000;

    private String Enter_Number = "0";
    private static int Money_Enter = 0;
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

        Lotto lotto = new Lotto(Winning_Number);
        lotto.Check_Lottey(Bonus_Number, Winning_Number, mylist);
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

        List<Integer> Print_Number = new ArrayList<>(number);
        Collections.sort(Print_Number);
        System.out.println(Print_Number);
    }

    public void Number_of_Win_Print(int[] Number_of_Win, int Bounus_Win, int Jackpot) {
        double Sum = ((double) Jackpot / (double) this.Money_Enter) * 100;
        System.out.println(Three_Matche + Number_of_Win[3] + Point);
        System.out.println(Four_Matche + Number_of_Win[4] + Point);
        System.out.println(Five_Matche + Number_of_Win[5] + Point);
        System.out.println(Five_Matche_Bounus + Bounus_Win + Point);
        System.out.println(Six_Matche + Number_of_Win[6] + Point);
        System.out.println("총 수익률은 " + String.format("%.1f", Sum) + "%입니다.");

    }


}
