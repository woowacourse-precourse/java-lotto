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
        String inputLottoNumber;

        int number=Integer.valueOf(purchaseAmount)/1000;


        System.out.printf("%d"+Message.TOTAL.getMessage(),number);



    }
}
