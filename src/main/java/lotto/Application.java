package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoConsole lottoConsole = new LottoConsole();

        try{
            lottoConsole.inputMoney();
            lottoConsole.printLottoNumbers();
            lottoConsole.inputNumbers();
            lottoConsole.printResult();
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}