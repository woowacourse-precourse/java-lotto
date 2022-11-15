package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    
    public List<Integer> getNumbers(){
    	return this.numbers;
    }
    
    public void printNumbers() {
    	List<Integer> sortednumbers = new ArrayList<>(numbers);
    	Collections.sort(sortednumbers);
    	System.out.print("["+sortednumbers.get(0));
    	for(int i=1;i<sortednumbers.size();i++) 
    		System.out.print(", "+sortednumbers.get(i));
    	System.out.println("]");
    }
}
