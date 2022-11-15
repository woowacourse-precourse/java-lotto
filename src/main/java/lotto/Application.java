package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static Purchaser purchaser;
    public static Lotto lotto;

    public static void main(String[] args) throws IllegalArgumentException {

        // TODO: 프로그램 구현
        try {
            // 로또 구매 및 구매한 로또 번호들에 파트
            purchaser = new Purchaser();
            purchaser.setCost();
            purchaser.receiveLottoNumbers();
            purchaser.printLottoNums();

//            // 당첨 및 보너스 번호 입력
            List<Integer> winningNumber = enterWinnigNumber();
            lotto = new Lotto(winningNumber);
            lotto.setBonusNumber();

            Calculation.calculateWinningDetails(purchaser, lotto);
            purchaser.totalEarns = Calculation.calculateTotalEarns(purchaser, lotto);

            Outputs.printWinningDetails();
            Outputs.printEarningRatio(purchaser);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    public static List enterWinnigNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");

        String[] winningNumbers = Console.readLine().split(",");
        List<Integer> lottoNum = new ArrayList<>();
        for(int i=0; i<winningNumbers.length; ++i){
            lottoNum.add(Integer.parseInt(winningNumbers[i]));
        }

        System.out.println();
        return lottoNum;
    }

}
