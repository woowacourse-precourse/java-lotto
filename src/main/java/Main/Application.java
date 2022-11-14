package Main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Print.Message;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        //BuyLotto butlotto = new BuyLotto();
    	
    	Message.INPUT_MONEY.print();
    	String s = Console.readLine();
    	try {
    		change(s);
    	}
    	catch(IllegalArgumentException e) {
    		System.out.println(e.getMessage());
    		return;
    	}
    	
    	int n = Integer.parseInt(s) / 1000;
    	
    	ArrayList<Integer>[] arr = new ArrayList[n];
    	for(int i = 0; i < n; i++) {
    		arr[i] = new ArrayList<>();
    	}
    	
    	Message.LOTTO_COUNT.print_count(n);
    	for(int i = 0; i < n; i++) {
    		
    		arr[i] = new ArrayList<>(input());
    		
    		Collections.sort(arr[i]);
    		
    		System.out.println(arr[i]);
    	}
    	
    	Message.INPUT_WINNER_NUMBER.print();
    	String[] win_number_string = Console.readLine().split(",");
    	
    	int[] win_number = new int[win_number_string.length];
    	for(int i = 0; i < win_number_string.length; i++) {
    		win_number[i] = Integer.parseInt(win_number_string[i]);
    		
    		if(win_number[i] < 1 || win_number[i] > 45) {
    			System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    			return;
    		}
    	}
    	
    	Message.INPUT_BONUS_NUMBER.print();
    	int bonus_number = Integer.parseInt(Console.readLine());
    	
    	Message.WINNING_STATES.print();
    	
    	int[] result_price = {0, 0, 0, 5000, 50000, 1500000, 30000000, 2000000000};
    	String[] result_print = {"", "", "", "3개 일치 (5,000원)", "4개 일치 (50,000원)", "5개 일치 (1,500,000원)", "5개 일치, 보너스 볼 일치 (30,000,000원)", "6개 일치 (2,000,000,000원)"};
    	int[] result_count = new int[result_print.length];
    	for(int i = 0; i < arr.length; i++) {
    		int count = result(arr[i], win_number);
    		
    		if(count < 3 || count > 6) {
    			continue;
    		}
    		
    		if(count == 6 || (count == 5 && check_bonus_number(arr[i], bonus_number))) {
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
    
    public static void change(String s) {
    	int n = 0;
    	try {
    		n = Integer.parseInt(s);
    	}
    	catch(NumberFormatException e) {
    		throw new IllegalArgumentException("[ERROR] ");
    	}
    }
    
    public static int result(ArrayList<Integer> arr, int[] win_number) {
    	int number_count = 0;
    	for(int i = 0; i < win_number.length; i++) {
			if(arr.contains(win_number[i])) {
				number_count++;
			}
		}
    	
    	return number_count;
    }
    
    public static boolean check_bonus_number(ArrayList<Integer> arr, int bonus_number) {
    	return arr.contains(bonus_number);
    }
    
    public static List<Integer> input(){
    	List<Integer> input_number;
    	
    	input_number = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    	
    	return input_number;
    }
}
