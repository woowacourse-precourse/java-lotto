package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
    	String money = getFromUser();
    	List<Lotto> lottoNumbers = createLottoNumbers(money);
    	String WinningNumber = getFromUser();
    	String bonusNumber = getFromUser();
        // TODO: 프로그램 구현
    }
    
    public static String getFromUser() {
    	String result = Console.readLine();
    	return result;
    }
    
    public static List<Lotto> createLottoNumbers(String money) {
    	int count = Integer.parseInt(money)/1000;
    	List<Lotto> lottoNumbers = new ArrayList<>();
    	
    	for(int i=0; i<count;i++) {
    		Lotto lottoNumber = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        	lottoNumbers.add(lottoNumber);
    	}

    	return lottoNumbers;
    }
}
