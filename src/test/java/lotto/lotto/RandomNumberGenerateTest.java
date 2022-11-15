package lotto.lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class RandomNumberGenerateTest{

	@DisplayName("입력한 예산과 그에 따른 게임횟수와 동일한 리스트를 담는지 여부")
	@Test
	void isNumberOfGameEqualListSize() {
		int numberOfGame = 5;
	randomNumberGenerate randomNumberGenerate = new randomNumberGenerate(numberOfGame);
	assertThat(randomNumberGenerate.numbers.size()).isEqualTo(5);
		int numberOfGame2 = 10;
		randomNumberGenerate randomNumberGenerate2 = new randomNumberGenerate(numberOfGame2);
		assertThat(randomNumberGenerate2.numbers.size()).isEqualTo(10);
		int numberOfGame3 = 100;
		randomNumberGenerate randomNumberGenerate3 = new randomNumberGenerate(numberOfGame3);
		assertThat(randomNumberGenerate3.numbers.size()).isEqualTo(100);

	}

	@DisplayName("List 내의 로또번호가 오름차순으로 정렬되어있는지 여부")
	@Test
	void isListSorted() {
		int numberOfGame = 10;
		randomNumberGenerate randomNumberGenerate = new randomNumberGenerate(numberOfGame);
		for (int i=0; randomNumberGenerate.numbers.size()>i;i++){
			for (int k=0; randomNumberGenerate.numbers.get(i).size()-1>k;k++){
				assertThat(randomNumberGenerate.numbers.get(i).get(k)
					< randomNumberGenerate.numbers.get(i).get(k+1)).isTrue();
			}
		}

	}

}
