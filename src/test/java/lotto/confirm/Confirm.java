package confirm;

import java.util.List;

import calculate.Calculate;

public class Confirm {
	public static void start(List<List<Integer>> playerPick) {
		try {
			System.out.println("당첨 번호를 입력해 주세요.");
			List<Integer> winNums = WinNumList.run();
			System.out.println("보너스 번호를 입력해 주세요.");
			winNums = BonusNum.run(winNums);
			WinNumErrorCheck.run(winNums);
			
			List<Integer> correctNums = WinList.run(playerPick, winNums);
			Calculate.run(correctNums);
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
		}
		
	}
}
