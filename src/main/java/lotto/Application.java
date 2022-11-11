package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    //region 상수
    private static final String EMPTY_STRING = "";
    private static final String REGEX = "[0-9]+";
    private static final int lottoPrice = 1000;
    private static final String purchasingAmountWord = "구입금액을 입력해 주세요.";
    private static final String ErrorPrice = "로또 구입 금액은 1,000원 단위로 입력하셔야 합니다.";
    private static final String ErrorSalesAmount = "구매 금액에 숫자가 아닌것이 포함되어 있습니다.";
    //endregion

    //region 변수
    public static int numberOfLotto;
    //endregion

    //region 생성자
    public static void main(String[] args) {
        SalesLotto();
    }
    //endregion

    //region 메서드

    public static String getUserInputData(){
        String input = Console.readLine();
        return input;
    }

    public static void SalesLotto(){
        System.out.println(purchasingAmountWord);
        String userInput = getUserInputData();
        SalesValidate(userInput);

        calculateNumberLotto(userInput);
        Lotto.SalesLotto(numberOfLotto);
    }

    public static void calculateNumberLotto(String userInput){
        int userPay = Integer.parseInt(userInput);
        numberOfLotto = userPay / lottoPrice;
    }

    private static boolean SalesValidate(String userInput) {
        String errorMessage;

        errorMessage = CheckOnlyNumber(userInput);
        if(!errorMessage.isEmpty()) {
            Error.error(errorMessage);
            return false;
        }

        errorMessage = CheckPrice(userInput);
        if(!errorMessage.isEmpty()) {
            Error.error(errorMessage);
            return false;
        }

        return true;
    }

    private static String CheckPrice(String userInput) {
        int userPay = Integer.parseInt(userInput);

        if(userPay % lottoPrice != 0)
            return ErrorPrice;

        return EMPTY_STRING;
    }


    public static String CheckOnlyNumber(String str){
        if(!str.matches(REGEX))
            return ErrorSalesAmount;

        return EMPTY_STRING;
    }
    //endregion
}
