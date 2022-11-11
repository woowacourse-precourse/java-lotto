package lotto;

import java.util.ArrayList;
import java.util.List;

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
        print.printNumberAll(lottonumbersall,lottonum);
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
    	int lottocount = 0;
    	return lottocount;
    }
    
    public void lottoValidateNumber() {
    	
    }
    
    public void askBonusNumber() {
    	
    }
}
