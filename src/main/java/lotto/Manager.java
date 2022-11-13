package lotto;


import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Manager {
    static final String Statement = "구입금액을 입력해 주세요.";
    private int count;

    public Manager(int money) {
        if(money % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MONEY_IS_NOT_DIVISIBLE_BY_1000);
        }
        this.count = money / 1000;
    }
    public void inputMoneyStatementPrint() {
        System.out.println(Statement);
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
