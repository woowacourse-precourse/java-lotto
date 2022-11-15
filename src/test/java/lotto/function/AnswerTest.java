package lotto.function;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.Answer;
import lotto.Rank;
import lotto.User;

public class AnswerTest {
	private Answer answer;
	
	@BeforeEach
	void setup() {
		answer = new Answer();
	}
	
	@DisplayName("유저 구매 로또를 정답과 비교해주는 기능")
    @Test
    void evaluateLotto() {
		//given
		User user = new User();
		assertRandomUniqueNumbersInRangeTest(
				()->{
					user.getPurchaseCount("1000");
					user.addLotto();
				},
				List.of(1,2,3,4,5,6));
		
		answer.setNumbers("1,2,3,4,5,7");
		answer.setBonus("6");
		//when
		answer.evaluate(user);
		//then
		Map<Rank, Integer> rankCount = user.getRankCount();
		assertThat(rankCount.get(Rank.SECOND)).isEqualTo(1);
    }
}
