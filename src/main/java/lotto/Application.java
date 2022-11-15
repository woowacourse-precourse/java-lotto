package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class Application {

    static final String exceptionHeader="[ERROR] ";
    static final String inputMoneyExceptionNotInteger="숫자만 입력해주세요.\n";
    static final String inputMoneyExceptionStr="로또 금액은 1000원 입니다. 1000원 단위로 입력해주세요.\n";

    public static void getMoney(){
        String pattern="^[0-9]*$";
        String inputStr=Console.readLine();
        if(!Pattern.matches(pattern,inputStr)){
            throw new IllegalArgumentException(exceptionHeader+inputMoneyExceptionNotInteger);
        }

        int inputMoney = Integer.parseInt(inputStr);
        if(inputMoney%1000!=0){
            throw new IllegalArgumentException(exceptionHeader+inputMoneyExceptionStr);
        }
    }
    public static void main(String[] args) {

        getMoney();

    }
}
