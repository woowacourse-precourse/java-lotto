package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        inputPrint();
        String inputMoney = Console.readLine();
        int lottoCount = Lotto.calculate(inputMoney);
        countPrint(lottoCount);

        for(int i = 0; i < lottoCount; i++){
            List <Integer> numbers = new ArrayList<>();
            Lotto lotto = new Lotto(numbers);
        }
    }

    public static void inputPrint(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void countPrint(int lottoCount){
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

}