package lotto;


import static camp.nextstep.edu.missionutils.Console.*;



public class UI {
    static final String Request_Input_Price = "구입금액을 입력해 주세요.";
    static final String Request_Winning_Number = "당첨 번호를 입력해 주세요.";
    static final String Request_Bonus_Number = "보너스 번호를 입력해 주세요.";
    static final String Lot_Result = "당첨 통계";
    static final String Input_Number = "[ERROR]";
    static String Lot_EA = readLine();
    static String price = Lot_EA;
    static int EA = 0;
    public static String Lot_Count(int price){
        EA = price/1000;
        Lot_EA = EA+"개를 구매했습니다.";
        return Lot_EA;
    }
}
