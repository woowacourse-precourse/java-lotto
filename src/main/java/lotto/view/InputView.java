package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private int money;
    private Lotto answer;
    private int BonusNumber;

    public void inputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        money = Integer.parseInt(Console.readLine());
        validateInputMoney(money);
    }
    public int getMoney(){
        return money;
    }
    public void validateInputMoney(int inputMoney){
        if(inputMoney%1000 != 0){
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위여야 합니다.");
        }
    }

    public void inputAnswer(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] inputAnswer = Console.readLine().split(",");
        List<Integer> numbers = new ArrayList<>();
        for(String input : inputAnswer){
            numbers.add(Integer.parseInt(input));
        }
       this.answer = new Lotto(numbers);

    }

    public Lotto getAnswer(){
        return this.answer;
    }

    public void inputBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        this.BonusNumber = Integer.parseInt(Console.readLine());
    }

    public int getBonusNumber(){
        return this.BonusNumber;
    }

}
