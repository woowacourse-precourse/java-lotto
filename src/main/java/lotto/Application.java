package lotto;


import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputController;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.ConsoleHandler;

public class Application {


    public static void main(String[] args) {

        Computer computer = new Computer();
        InputController inputController = new InputController();
        System.out.println("구입금액을 입력해 주세요.");
        Integer number = inputController.getBuyAmount(Console.readLine());


        List<List<Integer>> lottonumbers = new ArrayList<>();
        while (lottonumbers.size() < number / 1000) {
            List<Integer> lottoNumber = computer.getLottoNumber();
            Lotto lotto = new Lotto(lottoNumber);
            System.out.println(lottoNumber);
            lottonumbers.add(lottoNumber);
        }

        System.out.println("당첨 번호를 입력해 주세요.");
        String strWinNumbers = Console.readLine();
        System.out.println(strWinNumbers);
        List<Integer> winNumbers = inputController.getWinNumbers(strWinNumbers);








    }
}
