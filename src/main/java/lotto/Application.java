package lotto;


import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputController;

import java.util.ArrayList;
import java.util.List;

public class Application {


    public static void main(String[] args) {


        System.out.println("구입금액을 입력해 주세요.");
        String strBuyAmount = Console.readLine();
        InputController inputController = new InputController();
        Integer number = inputController.getBuyAmount(strBuyAmount);


        List<List<Integer>> lottonumbers = new ArrayList<>();
        while (lottonumbers.size() < number / 1000) {
            Computer computer = new Computer();
            List<Integer> lottoNumber = computer.getLottoNumber();
            Lotto lotto = new Lotto(lottoNumber);
            lottonumbers.add(lottoNumber);
        }



    }
}
