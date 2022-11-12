package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Application {

    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 45;
    public static final int LOTTO_SIZE = 6;

    public static void main(String[] args) {

        System.out.println(Message.START.getMessage());
        String purchaseAmount = Console.readLine();
        String winningNumber;

        int number=Integer.valueOf(purchaseAmount)/1000;


        System.out.printf("%d"+Message.TOTAL.getMessage()+"\n",number);

        List<Integer>[] userLotto= new ArrayList[number];
        for(int i=0;i<number;i++){
            userLotto[i]=new ArrayList<Integer>();
        }

        for(int i=0;i<number;i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER, LOTTO_SIZE);
            Collections.sort(randomNumbers);
            for (int j = 0; j < randomNumbers.size(); j++) {
                userLotto[i].add(randomNumbers.get(j));
            }
        }

        for(int i=0;i<number;i++) {
            System.out.println(userLotto[i]);
        }

        System.out.println(Message.INPUT.getMessage());
        winningNumber=Console.readLine();
        String[] winningNumberSplit=winningNumber.split(",");

        List<Integer> winningLottoNumber = new ArrayList<>();

        for(int i=0;i<winningNumberSplit.length;i++){
            winningLottoNumber.add(winningNumberSplit[i].charAt(0)-'0');
        }




    }
}
