package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Application {
    static final String inputMoneyStr="구입금액을 입력해 주세요.\n";
    static final String inputMoneyPrint="개를 구매했습니다.\n";
    static final String exceptionHeader="[ERROR] ";
    static final String inputMoneyExceptionNotInteger="숫자만 입력해주세요.\n";
    static final String inputMoneyExceptionStr="로또 금액은 1000원 입니다. 1000원 단위로 입력해주세요.\n";
    static int lottoNumber;
    static List<List<Integer>> randomNumbers=new ArrayList<>();

    public static void getMoney(){
        System.out.print(inputMoneyStr);

        String pattern="^[0-9]*$";
        String inputStr=Console.readLine();
        if(!Pattern.matches(pattern,inputStr)){
            throw new IllegalArgumentException(exceptionHeader+inputMoneyExceptionNotInteger);
        }

        int inputMoney = Integer.parseInt(inputStr);
        if(inputMoney%1000!=0){
            throw new IllegalArgumentException(exceptionHeader+inputMoneyExceptionStr);
        }

        lottoNumber=inputMoney/1000;
        System.out.print(lottoNumber+inputMoneyPrint);
    }
    public static void printOut(int num) {
        List<Integer> numbers=randomNumbers.get(num);

        System.out.print("[");
        for (int i = 0; i < numbers.size() - 1; i++) {
            System.out.print(String.format("%d, ", numbers.get(i)));
        }
        System.out.print(numbers.get(6));
        System.out.println("]");
    }
    public static void makeRandomNumbers() {
        for (int lotto=0;lotto<lottoNumber;lotto++) {
            List<Integer> pickNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 7);
            Collections.sort(pickNumbers);
            randomNumbers.add(pickNumbers);
            printOut(lotto);
        }
    }
    public static void main(String[] args) {

        getMoney();
        makeRandomNumbers();
    }
}
