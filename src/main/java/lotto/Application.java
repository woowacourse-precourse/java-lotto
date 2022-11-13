package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
    	int count = getCount();
    	List<Lotto> lottoNumbers = createLottoNumbers(count);
    	List<Integer> WinningNumber = getWinningNumber();
    	String bonusNumber = getBonusNumber();
    	
    	createLottoNumbers(count);
    	printLottoNumbers(count,lottoNumbers);
    	//printWinningResult(WinningNumber,bonusNumber,lottoNumbers);
    	
    	return;
        // TODO: 프로그램 구현
    }
    
    public static int getCount() {
    	System.out.println("구입금액을 입력해 주세요.");
    	String input = Console.readLine();
    	int result = Integer.parseInt(input);
    	
    	if(result%1000!=0)
    		throw new IllegalArgumentException("[ERROR]");
    		
    	return result/1000;
    }
    
    public static List<Integer> getWinningNumber() {
    	int eachNumber;
    	List<Integer> result = new ArrayList<>();
    	
    	System.out.println("당첨 번호를 입력해 주세요.");
    	String input = Console.readLine();
    
    	String[] inputSplited = input.split(",");
    	for(String s:inputSplited) {
    		eachNumber = Integer.parseInt(s);
    		if(eachNumber<1 || eachNumber>46)
    			throw new IllegalArgumentException("[ERROR]");
    		result.add(eachNumber);
    	}

    	if(result.size()!=6)
    		throw new IllegalArgumentException("[ERROR]");
    	
    	return result;
    }
    
    public static String getBonusNumber() {
    	System.out.println("보너스 번호를 입력해 주세요.");
    	return Console.readLine();
    }
    
    public static String getFromUser() {
    	String result = Console.readLine();
    	return result;
    }
    
    public static List<Lotto> createLottoNumbers(int count) {
    	List<Lotto> lottoNumbers = new ArrayList<>();
    	
    	for(int i=0; i<count;i++) {
    		Lotto lottoNumber = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        	lottoNumbers.add(lottoNumber);
    	}

    	return lottoNumbers;
    }
    
    public static void printLottoNumbers(int count,List<Lotto> lottoNumbers) {
    	System.out.println(count+"개를 구매했습니다.");
    	for(Lotto lotto:lottoNumbers)
    		lotto.printNumbers();
    }    
    
    public static void printWinningResult(String WinningNumber,String bonusNumber, List<Lotto> lottoNumbers) {
    	for(Lotto lotto:lottoNumbers) {
    		int a = comparison(WinningNumber,bonusNumber, lotto);
    	}
    }
    
    public static int comparison(String WinningNumber,String bonusNumber, Lotto lottoNumber) {
    	return 1;
    }
}
