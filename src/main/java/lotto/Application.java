package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.assertj.core.util.Arrays;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
    	int price = 0;                  
        price = askTotalPrice();               // 사용자 입력으로 금액 입력받기
        
        int lottonum = 0;
        LottoCount lottocount = new LottoCount(price);
        lottonum = lottocount.lottonum;         // 사용자 입력으로 받은 금액 / 1000을 해서 로또 개수 구하기
        
        List<ArrayList<Integer>> lottonumbersall; 
        NumberGenerator numbergenerator = new NumberGenerator();
        lottonumbersall = numbergenerator.createRandomLotto(lottonum);  // 로또 개수만큼 랜덤 로또 숫자 6개씩 추출해서 리스트에 넣기
        
        Print print = new Print();
        print.printNumberAll(lottonumbersall,lottonum);  // 로또 개수와 로또 번호들을 모두 출력해주기
    }
    
    public static int askTotalPrice() {
    	String stringprice = "";
    	int price = 0;
    	
    	System.out.println("구입금액을 입력해 주세요.");
    	stringprice = Console.readLine();
    	price = Integer.parseInt(stringprice);
    	
    	return price;
    }
    
    public static int askNumbers() {
    	List<Integer> numbers = new ArrayList<>();
    	
    	System.out.println("당첨 번호를 입력해 주세요.");
    	String stringnumbers = Console.readLine();
    	
    	lottoValidateNumber(stringnumbers);
    	
    	String[] numbersarray = stringnumbers.split(",");
    	for (String number : numbersarray) {
    		numbers.add(Integer.parseInt(number));
    	}
    	
    	Lotto lotto = new Lotto(numbers);
    }
    
    public static void lottoValidateNumber(String stringnumbers) {
    	String pattern = "^[1-45],[1-45],[1-45],[1-45],[1-45],[1-45]$";
    	if (!Pattern.matches(pattern, stringnumbers)) {
    		throw new IllegalArgumentException("[ERROR] 1-45사이의 6개의 숫자를 ,로 구분해서 입력하세요.");
    	}
    }
    
    public void askBonusNumber() {
    	
    }
}
