package lotto.constant;

public class Constant {
    public static String Error_Message = "[ERROR] ";
    public static String OutOfBounds = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static String Count_Numbers = "로또 번호는 6개만 뽑아야 합니다.";
    public static String Duplicate_Numbers = "로또 번호는 중복될 수 없습니다.";
    public static String No_Insert = "구매 금액을 입력하세요.";
    public static String Only_Numbers = "문자열은 숫자만 입력할 수 있습니다.";
    public static String Buy_Per_1000 = "구매는 1000원 단위로만 구매할 수 있습니다.";
    
    

    public static String Print_Buy_Per_1000(){
        return Error_Message + Buy_Per_1000;
    }
    
    public static String Print_Only_Numbers(){
        return Error_Message + Only_Numbers;
    }

    public static String Print_No_Insert(){
        return Error_Message + No_Insert;
    }

    public static String Print_OutOfBounds(){
        return Error_Message + OutOfBounds;
    }

    public static String Print_CountNumbers(){
        return Error_Message + Count_Numbers;
    }

    public static String Print_Duplicate_Numbers(){
        return Error_Message + Duplicate_Numbers;
    }
}