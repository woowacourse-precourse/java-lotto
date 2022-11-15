package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.regex.Pattern;

import static lotto.collectionPrintout.*;

public class Application {

    static int lottoNumber;
    static List<List<Integer>> randomNumbers=new ArrayList<>();

    public static void getMoney(){
        System.out.print(inputMoneyStr);

        String pattern="^[0-9]*$";
        String inputStr=Console.readLine();
        if(!Pattern.matches(pattern,inputStr)){
            throw new IllegalArgumentException(exceptionHeader+notInteger);
        }

        int inputMoney = Integer.parseInt(inputStr);
        if(inputMoney%1000!=0){
            throw new IllegalArgumentException(exceptionHeader+wrongUnit);
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
    public static void getWinningNumbers(){
        System.out.println(winningNumbersStr);
        Lotto lotto=new Lotto(stringToListInteger(Console.readLine()));
        System.out.println(bonusNumbersStr);
        lotto.addBonusNumber(Integer.parseInt(Console.readLine()));
    }
    public static List<Integer> stringToListInteger(String str) {
        String[] strArray = str.split(",");
        List<Integer> list=new ArrayList<>();

        for(int i=0;i<strArray.length;i++){
            list.add(Integer.parseInt(strArray[i]));
        }
        return list;
    }
    public static void main(String[] args) {

        getMoney();
        makeRandomNumbers();
        getWinningNumbers();

    }
}
