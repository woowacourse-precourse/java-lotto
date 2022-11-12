package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public abstract class Utility {

    public void printMessage(String message){
        System.out.println(message);
    }

    public String receiveInput(){
        String input = Console.readLine();
        return input;
    }

    public long calculateQuotient(long dividend, long divisor){
        return dividend/divisor;
    }

    public Lotto createLotto(){
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lotto = new Lotto(lottoNumbers);
        return lotto;
    }
}
