package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

public class LottoSystem {


    public int lottoAmount(){
        System.out.println("구매금액을 입력해 주세요.");
        String puchaseLottoMoney = Console.readLine();
        return Integer.parseInt(puchaseLottoMoney);
    }
}
