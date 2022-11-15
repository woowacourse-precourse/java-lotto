package lotto.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class randomNumberGenerate {
	public ArrayList<List<Integer>> numbers;
		public randomNumberGenerate(int gameCount){
			this.numbers = new ArrayList<>();
			int count = 0;
			do{
				randomNumber newLotto = new randomNumber();
				Lotto validateLotto = new Lotto(newLotto.lotto);
				count ++;
				ArrayList<Integer> answerNumber= new ArrayList<>(newLotto.lotto);
				Collections.sort(answerNumber);
				numbers.add(answerNumber);
			}while (count != gameCount);
		}
}
