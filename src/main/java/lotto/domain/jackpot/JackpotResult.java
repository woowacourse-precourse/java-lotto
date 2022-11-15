package lotto.domain.jackpot;
//예기치 못한 오류 테스트 커밋
public class JackpotResult {
	private static int jackpot_count=0;

	private static int bonus_count=0;

	public static void hit_jackpot(){
		jackpot_count++;
	}

	public static void hit_bonus(){
		bonus_count++;
	}

	public static int return_jackpot_count(){
		return jackpot_count;
	}

	public static int return_bonus_count(){
		return bonus_count;
	}

	public static void reset_count(){
		jackpot_count=0;
		bonus_count=0;
	}
}
