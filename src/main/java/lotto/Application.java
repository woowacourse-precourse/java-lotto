package lotto;

import java.util.List;

import Print.Result;
import User.User;

public class Application {
    public static void main(String[] args) {
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
    	
		Result.print(arr, win_number, bonus_number, n);
    }
}
