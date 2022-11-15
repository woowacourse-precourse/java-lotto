package lotto.domain.win;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningTest {

	@DisplayName("숫자일치 개수와 보너스 번호 일치여부에 따른 상수값 출력(FIRST)")
	@Test
	void getWinningFirst() {
		assertEquals(Winning.FIRST,Winning.getWinning(6,false));
	}
	@DisplayName("숫자일치 개수와 보너스 번호 일치여부에 따른 상수값 출력(SECOND)")
	@Test
	void getWinningSecond() {
		assertEquals(Winning.SECOND,Winning.getWinning(5,true));
	}
	@DisplayName("숫자일치 개수와 보너스 번호 일치여부에 따른 상수값 출력(THIRD)")
	@Test
	void getWinningThird() {
		assertEquals(Winning.THIRD,Winning.getWinning(5,false));
	}@DisplayName("숫자일치 개수와 보너스 번호 일치여부에 따른 상수값 출력(FOURTH)")
	@Test
	void getWinningFourth() {
		assertEquals(Winning.FOURTH,Winning.getWinning(4,false));
	}@DisplayName("숫자일치 개수와 보너스 번호 일치여부에 따른 상수값 출력(FIFTH)")
	@Test
	void getWinningFifth() {
		assertEquals(Winning.FIFTH,Winning.getWinning(3,false));
	}


}