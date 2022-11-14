package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LottoSystem {
    private int TICKET_PRICE = 1000;
    private int LOTTO_SIZE = 6;
    private Scanner scanner = new Scanner(System.in);



    private int lottoPurchaseAmount(){
     String purchaseAmount;

     System.out.println("구매 금액을 입력해 주세요");
     purchaseAmount = scanner.nextLine();
     return Integer.parseInt(purchaseAmount);
 }



}


