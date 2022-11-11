package lotto;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoSystemTest {

	List<List<Integer>> games = List.of(
		List.of(8, 21, 23, 41, 42, 43),
		List.of(3, 5, 11, 16, 32, 38),
		List.of(7, 11, 16, 35, 36, 44),
		List.of(1, 8, 11, 31, 41, 42),
		List.of(13, 14, 16, 38, 42, 45),
		List.of(7, 11, 30, 40, 42, 43),
		List.of(2, 13, 22, 32, 38, 45),
		List.of(1, 3, 5, 14, 22, 45));

	List<Integer> winNumber = List.of(1, 2, 3, 4, 5, 6);

	public int getCount(int i, List<Integer> list) {
		int count = 0;
		if (list.contains(i)) {
			count++;
		}
		return count;
	}

	@Test
	void compare() {
		int firstPlace = 0;
		int secondPlace = 0;
		int thirdPlace = 0;
		int fourthPlace = 0;
		int fifthPlace = 0;
		int bonusNumber = 7;

		for (List<Integer> game : games) {
			int count = 0;
			count = getCount(winNumber, game, count);
			if (count == 6) {
				firstPlace++;
			}
			if (count == 5 && game.contains(bonusNumber)) {
				secondPlace++;
			}
			if (count == 5 && !game.contains(bonusNumber)) {
				thirdPlace++;
			}
			if (count == 4) {
				fourthPlace++;
			}
			if (count == 3) {
				fifthPlace++;
			}
		}

		Assertions.assertThat(firstPlace).isEqualTo(0);
		Assertions.assertThat(secondPlace).isEqualTo(0);
		Assertions.assertThat(thirdPlace).isEqualTo(0);
		Assertions.assertThat(fourthPlace).isEqualTo(0);
		Assertions.assertThat(fifthPlace).isEqualTo(1);
	}

	private static int getCount(List<Integer> winNumber, List<Integer> game, int count) {
		for (Integer integer : game) {
			if (winNumber.contains(integer)) {
				count++;
			}
		}
		return count;
	}

}