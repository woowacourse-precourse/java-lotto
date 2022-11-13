package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class View {

    public View(){

    }

    /**
     * input money by user
     * @return user input value
     */
    public String inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    /**
     * print generated lotto list
     * @param lottoList generated lotto list
     */
    public void printPurchase(List<Lotto> lottoList) {
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }

    /**
     * @return List<String> input winning number and return list split
     */
    public List<String> inputWinNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return Arrays.asList(input.split(","));
    }
}
