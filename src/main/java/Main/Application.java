package Main;

import java.util.List;

import Print.Message;
import User.User;
import lotto.BuyLotto;
import lotto.Lotto;

public class Application {
    public static void main(String[] args) {
        //BuyLotto butlotto = new BuyLotto();
    	
    	User user = new User();
    	
    	int n = user.input_money();
    	
    	if(n == 0) {
    		return;
    	}
    	
		List<Lotto> arr = BuyLotto.print(n);
    	
    	List<Integer> win_number = user.winning_number();
    	
    	if(win_number.size() == 0) {
    		return;
    	}
    	
    	int bonus_number = user.winning_number_bonus();
    	
    	Message.WINNING_STATES.print();
    	
    	int[] result_price = {0, 0, 0, 5000, 50000, 1500000, 30000000, 2000000000};
    	String[] result_print = {"", "", "", "3개 일치 (5,000원)", "4개 일치 (50,000원)", "5개 일치 (1,500,000원)", "5개 일치, 보너스 볼 일치 (30,000,000원)", "6개 일치 (2,000,000,000원)"};
    	int[] result_count = new int[result_print.length];
    	for(int i = 0; i < arr.size(); i++) {
    		int count = result(arr.get(i).getnumber(), win_number);
    		
    		if(count < 3 || count > 6) {
    			continue;
    		}
    		
    		if(count == 6 || (count == 5 && check_bonus_number(arr.get(i).getnumber(), bonus_number))) {
    			result_count[count + 1]++;
    			continue;
    		}
    		result_count[count]++;
    	}
    	
    	double profit = 0;
    	for(int i = 3; i < result_print.length; i++) {
    		System.out.println(result_print[i] + " - " + result_count[i] + "개");
    		profit += result_count[i] * result_price[i];
    	}
    	
    	profit = profit / (n * 1000) * 100;
    	
    	Message.PROFIT.print_profit(profit);
    }
    
    public static int result(List<Integer> arr, List<Integer> win_number) {
    	int number_count = 0;
    	for(int i = 0; i < win_number.size(); i++) {
			if(arr.contains(win_number.get(i))) {
				number_count++;
			}
		}
    	
    	return number_count;
    }
    
    public static boolean check_bonus_number(List<Integer> arr, int bonus_number) {
    	return arr.contains(bonus_number);
    }
}
