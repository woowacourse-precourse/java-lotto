package player;

import java.util.List;

public class ShowNums {
	public static void run(List<Integer> arr) {
		int[] arr2 = new int[6];
		for (int i = 0; i < 6; i++) {
			arr2[i] = arr.get(i);
		}
		System.out.printf("[%d, %d, %d, %d, %d, %d]\n", arr2[0], arr2[1], arr2[2], arr2[3], arr2[4], arr2[5]);
	}
}
