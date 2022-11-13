package lotto;


import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Manager {
    static final String requestMoneyStatement = "구입금액을 입력해 주세요.";
    static final String requestLottoNumberStatement = "당첨 번호를 입력해 주세요.";
    static final String requestBonusNumberStatement = "보너스 번호를 입력해 주세요.";

    public void requestMoneyStatementPrint() {
        System.out.println(requestMoneyStatement);
    }
    public int inputMoney() {
        int money;
        String inputMoneyString = Console.readLine();
        try {
            money = Integer.parseInt(inputMoneyString);
        }
        catch(NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_IS_NOT_INTEGER);
        }
        return money;
    }
//    public List<List<Integer>> generator() {
//        for(int i = 0; i<numberOfPurchase; i++) {
//
//        }
//    }
//    public void generateResultPrint() {
//        System.out.println(numberOfPurchase + "개를 구매했습니다");
//
//    }


    public void requestLottoNumberStatementPrint() {
        System.out.println(requestLottoNumberStatement);
    }
    public List<Integer> inputLottoNumber() {
        List<Integer> lottoNumbers = new ArrayList<>();
        String lottoNumber = Console.readLine();
        String[] number = lottoNumber.split(",");
        for(String num: number) {
            try {
                lottoNumbers.add(Integer.parseInt(num));
            }
            catch(NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_IS_NOT_INTEGER);
            }
        }
        return lottoNumbers;
    }


}
