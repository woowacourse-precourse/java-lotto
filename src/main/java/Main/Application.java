package Main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        //BuyLotto butlotto = new BuyLotto();
    	
    	System.out.println("구입금액을 입력해 주세요.");
    	int n = Integer.parseInt(Console.readLine()) / 1000;
    	
    	ArrayList<Integer>[] arr = new ArrayList[n];
    	for(int i = 0; i < n; i++) {
    		arr[i] = new ArrayList<>();
    	}
    	
    	System.out.println("\n" + n + "개를 구매했습니다.");
    	for(int i = 0; i < n; i++) {
    		
    		arr[i] = input(n);
    		
    		System.out.print("[");
    		for(int j = 0; j < arr[i].size(); j++) {
    			System.out.print(arr[i].get(j));
    			if(j < arr[i].size() - 1) {
    				System.out.print(", ");
    			}
    		}
    		System.out.println("]");
    	}
    	
    	System.out.println("\n당첨 번호를 입력해 주세요.");
    	String[] win_number_string = Console.readLine().split(",");
    	
    	int[] win_number = new int[win_number_string.length];
    	for(int i = 0; i < win_number_string.length; i++) {
    		win_number[i] = Integer.parseInt(win_number_string[i]);
    		
    		if(win_number[i] < 1 || win_number[i] > 45) {
    			System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    			return;
    		}
    	}
    	
    	System.out.println("\n보너스 번호를 입력해 주세요.");
    	int bonus_number = Integer.parseInt(Console.readLine());
    	
    	System.out.println("\n당첨 통계");
    	System.out.println("---");
    	
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
    	
    	long sum = 0;
    	BigDecimal percent = BigDecimal.ONE;
    	for(int i = 3; i < result_print.length; i++) {
    		System.out.println(result_print[i] + " - " + result_count[i] + "개");
    		sum += result_count[i] * result_price[i];
    	}
    	
    	percent = new BigDecimal(sum).divide(new BigDecimal(n * 1000)).multiply(new BigDecimal(100));
    	
    	System.out.println("총 수익률은 " + String.format("%.1f", percent) + "%입니다.");
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
    
    public static ArrayList<Integer> input(int n){
    	ArrayList<Integer> input_number = new ArrayList<>();
    	
    	int count = 0;
		boolean[] check = new boolean[46];
    	while(count != 6) {
			int number = Randoms.pickNumberInRange(1, 45);
			
			if(!check[number]) {
				check[number] = true;
				input_number.add(number);
				count++;
			}
		}
    	
    	Collections.sort(input_number);
    	
    	return input_number;
    }
}
