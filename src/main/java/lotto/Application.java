package lotto;

import java.util.List;

import Print.Result;
import User.User;

public class Application {
    public static void main(String[] args) {
    	User user = new User();
    	
    	int user_input_number = user.input_money();
    	
    	if(check(user_input_number)) {
    		return;
    	}
    	
		List<Lotto> arr = BuyLotto.print(user_input_number);
    	List<Integer> win_number = user.winning_number();
    	
    	if(check(win_number.size())) {
    		return;
    	}
    	
    	int bonus_number = user.winning_number_bonus();
    	
    	if(check(bonus_number)) {
    		return;
    	}
    	
		Result.print(arr, win_number, bonus_number, user_input_number);
    }
    
    public static boolean check(int check_num) {
    	if(check_num == 0) {
    		return true;
    	}
    	return false;
    }
}
