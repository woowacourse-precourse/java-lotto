package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class User {
    static int lottoAmount;
    static List<Integer> guess;
    static int bonus;


    // get amount of lottos users would buy
    public static void buyLotto(){
        try{
            System.out.println("구입금액을 입력해주세요.");
            String lottoPayment = Console.readLine();
            validatePayment(lottoPayment);
            lottoAmount = Integer.valueOf(lottoPayment)/1000;
        }catch(IllegalArgumentException e) {
            System.err.println("[ERROR] "+e);
        }
    }

    private static void validatePayment(String lottoPayment) throws IllegalArgumentException {
        if(Integer.valueOf(lottoPayment)%1000!=0){
            throw new IllegalArgumentException();
        }
    }

    public static void guessLotto() throws IllegalArgumentException{
        System.out.println("당첨 번호를 입력해 주세요.");
        try{
            List<String> userGuessLotto = Arrays.asList(Console.readLine().split(",",6));
            guess = userGuessLotto.stream().map(Integer::parseInt).collect(Collectors.toList());
            new Lotto(guess);
        }catch(IllegalArgumentException e){
            System.err.println("[ERROR] "+e);
        }
    }

    public static void guessBonus() throws IllegalArgumentException{
        System.out.println("보너스 번호를 입력해 주세요.");
        try{
            bonus = Integer.valueOf(Console.readLine());
            Lotto.validateOne(bonus);
            Lotto.validDuplicate(bonus);
        }catch(IllegalArgumentException e){
            System.err.println("[ERROR] "+e);
        }
    }

}
