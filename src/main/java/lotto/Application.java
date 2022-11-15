package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        User user = new User();
        String userInput = user.input();
        int parseInput = user.checkInput(userInput);
        if(parseInput == 0) {
            return;
        }
        System.out.println(String.valueOf(parseInput)+"개를 구매했습니다.");
        List<Integer> answerNum = user.answerInput();
        if(answerNum.contains(0)){
            return;
        }
        int bonusNum= user.bonusInput();
        Lotto lotto = new Lotto(answerNum);
        List<List<Integer>> tmp =  lotto.lottoNumber(parseInput);
        int [] answer = lotto.check(tmp,bonusNum);
        user.announce(answer,parseInput*1000);
    }
}
