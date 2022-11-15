package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args){
    	int count =0;
    	try {
    		count = getCount();
    	}catch(Exception e) {
    		return;
    	}
    	if(count==-1)
    		return;
    	List<Lotto> lottoNumbers = createLottoNumbers(count);
    	List<Integer> WinningNumber = getWinningNumber();
    	int bonusNumber = getBonusNumber();
    	
    	createLottoNumbers(count);
    	printLottoNumbers(count,lottoNumbers);
    	
    	int earning = printWinningResult(WinningNumber,bonusNumber,lottoNumbers);
    	double winningRate = (double)earning/(count*10);
    	System.out.println("총 수익률은 "+Math.round(winningRate*100)/100.0+"%입니다.");
    	
    	return;
    }
    
    public static int getCount(){
    	System.out.println("구입금액을 입력해 주세요.");
    	String input = Console.readLine();
    	int result = 0;

    	try {
    		result = Integer.parseInt(input)/1000;
    	}catch(Exception e){
    		//e.printStackTrace();
    		System.out.println("[ERROR]");
    		
    		return -1;
    	}
    	
    	if(!(input.matches("-?\\d+000"))) {
    		System.out.println("[ERROR]");
    	}
    	
    	return result;
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
    
    public static int getBonusNumber() {
    	System.out.println("보너스 번호를 입력해 주세요.");
    	String input = Console.readLine();
    	int result = Integer.parseInt(input);
    	
    	if(result<1 || result>46)
			throw new IllegalArgumentException("[ERROR]");
    	
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
    
    public static int printWinningResult(List<Integer> winningNumber,int bonusNumber, List<Lotto> lottoNumbers) {
    	int[] result = new int[8];

    	for(Lotto lotto:lottoNumbers) {
    		int a = comparison(winningNumber,bonusNumber, lotto);
    		result[a]++;
    	}
    	
    	System.out.println("당첨 통계\n"
    			+ "---\n"
    			+ "3개 일치 (5,000원) - "+result[3]+"개\n"
    			+ "4개 일치 (50,000원) - "+result[4]+"개\n"
    			+ "5개 일치 (1,500,000원) - "+result[5]+"개\r\n"
    			+ "5개 일치, 보너스 볼 일치 (30,000,000원) - "+result[7]+"개\n"
    			+ "6개 일치 (2,000,000,000원) - "+result[6]+"개");
    	
    	return (5000*result[3]+50000*result[4]+1500000*result[5]+30000000*result[7]+2000000000*result[6]);
    }
    
    public static int comparison(List<Integer> winningNumber,int bonusNumber, Lotto lottoNumber) {
    	int result = 0;
    	Set<Integer> hash = new HashSet<>();
    	for(int i=0;i<6;i++) {
    		hash.add(winningNumber.get(i));
    		hash.add(lottoNumber.getNumbers().get(i));
    	}
    	result = 12-hash.size();
    	if(result==5 && winningNumber.contains(bonusNumber))
    		result+=2;
    	System.out.println(result);
    	return result;
    }
}
