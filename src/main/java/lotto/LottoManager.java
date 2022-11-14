package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoManager {
    private Money input;
    private Money benefit;
    private final LottoList lottos = new LottoList();
    private AnswerNumberList answerNumbers;

    private Long getAmountOfMoney(){
        String amountOfMoney = Console.readLine();
        try {
            return Long.valueOf(amountOfMoney);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    private void pickLottoNumbers(){
        Long amountOfLotto = input.getAmountOfLotto();
        for(int i = 0; i < amountOfLotto; i++){
            this.lottos.generateLotto();
        }
        System.out.println(amountOfLotto+"개를 구매했습니다.");
    }
    public void buyLotto(){
        Long amountOfMoney = getAmountOfMoney();
        this.input = new Money(amountOfMoney);
        pickLottoNumbers();
    }

    private List<Long> parseAnswerNumbers(String answerNumberString){
        return Arrays.stream(answerNumberString.split(",")).map(Long::valueOf).collect(Collectors.toList());
    }

    public void generateAnswerNumbers(){
        String answerNumberString = Console.readLine();
        List<Long> answerLongNumbers = parseAnswerNumbers(answerNumberString);
        String bonusNumberString = Console.readLine();
        Long bonusNumber = Long.valueOf(bonusNumberString);
        this.answerNumbers = new AnswerNumberList(answerLongNumbers, bonusNumber);
    }
}
