package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6자리가 아닙니다.");
        }
        
        HashSet<Integer> hash = new HashSet<>();
        
        for(Integer number:numbers)
    		hash.add(number);
    	
    	if(hash.size()!=6)
    		throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
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
