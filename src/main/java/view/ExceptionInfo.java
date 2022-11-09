package view;

public class ExceptionInfo {

    public static String ERROR_MESSAGE = "[ERROR]";
    public static String ERROR_NOT_NUMBER = ERROR_MESSAGE + "숫자가 아닌 것이 입력되었습니다.";
    public static String ERROR_INCORRECT_MONEY= ERROR_MESSAGE + "올바르지 못한 입력 금액입니다.";

    public static final int EXCEPTION_DETECT=-1;


    public static void printInCorrectMoney(){
        System.out.println(ERROR_INCORRECT_MONEY);
    }

    public static void printNotNumber(){
        System.out.println(ERROR_NOT_NUMBER);
    }



}
