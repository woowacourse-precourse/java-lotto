package confirm;

public class NumberInput {
	public static List<Integer> run(int num, List<Integer> answer) {
		if(num == 3) {
			answer.set(5, answer.get(5)+1);
	.	}
		if(num == 4) {			
      answer.set(4, answer.get(4)+1);
		}
		if(num == 5) {
			answer.set(3, answer.get(3)+1);
		}
		if(num == 15) {
			answer.set(2, answer.get(2)+1);
		}
		if(num == 6) {
			answer.set(1, answer.get(1)+1);
		}
	}
}
