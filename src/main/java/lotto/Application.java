package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.assertj.core.util.Arrays;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
    	int purchaseprice = 0;  
    	int lottonum = 0;
    	int bonusnumber = 0;
    	List<List<Integer>> lottonumbersall = null; 
    	List<Integer> inputnumbers = new ArrayList<Integer>();
    	
        purchaseprice = askTotalPrice();               // 사용자 입력으로 금액 입력받기
        
        LottoCount lottocount = new LottoCount(purchaseprice);
        lottonum = lottocount.lottonum;         // 사용자 입력으로 받은 금액 / 1000을 해서 로또 개수 구하기
        
        NumberGenerator numbergenerator = new NumberGenerator();
        lottonumbersall = numbergenerator.createRandomLotto(lottonum);  // 로또 개수만큼 랜덤 로또 숫자 6개씩 추출해서 리스트에 넣기
        
        Print print = new Print();
        print.printNumberAll(lottonumbersall, lottonum, purchaseprice);  // 로또 개수와 로또 번호들을 모두 출력해주기
        
        inputnumbers = askNumbers();  // 사용자 입력으로 6개 로또 번호들을 inputnumbers 리스트에 입력 받기
        
        bonusnumber = askBonusNumber(inputnumbers);  // 사용자 입력으로 보너스 숫자를 받아서 bonusnumber 변수에 저장하기
        
        print.countWin(inputnumbers, bonusnumber);  // 각 등수당 몇번 해당하는지 세어주는 기능
        
        print.printWin(); // 당첨 통계 출력하는 기능
        
        print.printProfitRound(print.printProfit()); // 계산된 수익률을 소수점 2째자리까지 출력해주는 기능
    }
    
    public static int askTotalPrice() {
    	String stringprice = "";
    	int price = 0;
    	boolean check = false;
    	while(check == false) {
    		System.out.println("구입금액을 입력해 주세요.");
    		stringprice = Console.readLine();
    		check = validateNumber(stringprice);
    	}
    	price = Integer.parseInt(stringprice);
    	System.out.println();
    	
    	return price;
    }
    
    public static boolean validateNumber(String stringprice) {
    	String pattern = "^[0-9]+$";
    	if (!Pattern.matches(pattern, stringprice)) {
    		System.out.println("[ERROR] 금액(숫자)를 입력해주세요.");
    		return false;
    	}
    	return true;
    }
    public static List<Integer> askNumbers() {
    	List<Integer> numbers = new ArrayList<>();
    	String stringnumbers = "";
    	String[] numbersarray;
    	
    	System.out.println("당첨 번호를 입력해 주세요.");
    	stringnumbers = Console.readLine();
    	
    	validateSplit(stringnumbers);         // 먼저 구분자로 입력값이 나누어지는지 확인
    	numbersarray = stringnumbers.split(",");  // 구분자 ,로 입력값을 나눠서 numbersarray에 담기
    	
    	validateLottoNumber(numbersarray);     // numbersarray에 담긴 값들이 모두 1-45까지의 숫자인지 확인
    	for (String number : numbersarray) {        //numbersarray값들(string)을 숫자로 바꿔서 numbers리스트에 담기
    		numbers.add(Integer.parseInt(number));
    	}
    	
    	Lotto lotto = new Lotto(numbers);
    	System.out.println();
    	
    	return lotto.getLottoNumbers();
    }
    
    public static void validateSplit(String stringnumbers) {
    	String[] numbersarray;
    	if (!stringnumbers.contains(",")) {
    		throw new IllegalArgumentException("[ERROR] 값을 ,로 구분해서 입력하세요.");
    	}
    }
    
    public static void validateLottoNumber(String[] numbersarray) {
    	String pattern = "^[0-9]{1,2}$";
    	for (String number : numbersarray) {
    		if (!Pattern.matches(pattern, number)) {
        		throw new IllegalArgumentException("[ERROR] 1-45사이의 숫자만 입력하세요.");
        	}
    		if (Integer.parseInt(number) < 1 || Integer.parseInt(number) > 45) {
    			throw new IllegalArgumentException("[ERROR] 1-45사이의 숫자만 입력하세요.");
    		}
    	}
    }
    
    public static int askBonusNumber(List<Integer> inputnumbers) {
    	String stringbonusnumber = "";
    	System.out.println("보너스 번호를 입력해 주세요.");
    	stringbonusnumber = Console.readLine();
    	
    	BonusNumber bonusnumber = new BonusNumber(stringbonusnumber,inputnumbers);
    	
    	System.out.println();
    	return bonusnumber.getBonusNumber();
    }
}
