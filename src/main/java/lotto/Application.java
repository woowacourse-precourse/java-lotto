package lotto;


import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Application {
    private static final int WIN_THREE = 3;
    private static final int WIN_FOUR = 4;
    private static final int WIN_FIVE = 5;
    private static final int WIN_FIVE_AND_BONUS = 1;
    private static final int WIN_ALL = 6;


    public static void main(String[] args) {

        Computer computer = new Computer();
        InputController inputController = new InputController();
        System.out.println("구입금액을 입력해 주세요.");
        Integer number = inputController.getBuyAmount(Console.readLine());

        System.out.println(number/1000+"개를 구매했습니다.");
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        while (lottoNumbers.size() < number / 1000) {
            List<Integer> lottoNumber = computer.getLottoNumber();
            Lotto lotto = new Lotto(lottoNumber);
            System.out.println(lottoNumber);
            lottoNumbers.add(lottoNumber);
        }

        System.out.println("당첨 번호를 입력해 주세요.");
        String strWinNumbers = Console.readLine();
        System.out.println(strWinNumbers);
        List<Integer> winNumbers = inputController.getWinNumbers(strWinNumbers);

        System.out.println("보너스 번호를 입력해 주세요.");
        Integer bonusNumber = inputController.getBonusNumber(Console.readLine(), winNumbers);
        System.out.println(bonusNumber);

        System.out.println("당첨 통계");
        System.out.println("---");

        HashMap<Integer, Integer> checkWin = new HashMap<>();
        checkWin.put(WIN_THREE, 0);
        checkWin.put(WIN_FOUR, 0);
        checkWin.put(WIN_FIVE, 0);
        checkWin.put(WIN_FIVE_AND_BONUS, 0);
        checkWin.put(WIN_ALL, 0);

        for (List<Integer> lottoNumber : lottoNumbers) {
            Lotto lotto = new Lotto(lottoNumber);
            Integer checkWinNum = lotto.checkWin(winNumbers);
            if (checkWinNum < WIN_THREE) {
                continue;
            }
            boolean checkBonusNum = lotto.checkBonusNumber(bonusNumber);
            if (checkWinNum == WIN_FIVE && checkBonusNum) {
                checkWin.put(WIN_FIVE_AND_BONUS, checkWin.get(WIN_FIVE_AND_BONUS) + 1);
            }
            checkWin.put(checkWinNum, checkWin.get(checkWinNum) + 1);
        }
        System.out.println("3개 일치 (5,000원) - "+checkWin.get(WIN_THREE)+"개");
        System.out.println("4개 일치 (50,000원) - "+checkWin.get(WIN_FOUR)+"개");
        System.out.println("5개 일치 (1,500,000원) - "+checkWin.get(WIN_FIVE)+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+checkWin.get(WIN_FIVE_AND_BONUS)+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+checkWin.get(WIN_ALL)+"개");
        Double earningRate = computer.getEarningRate(number, checkWin);
        System.out.println("총 수익률은 "+earningRate+"%입니다.");



    }
}
