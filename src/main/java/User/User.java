package User;

import java.util.ArrayList;
import java.util.List;

import Print.Error_Message;
import Print.Message;
import camp.nextstep.edu.missionutils.Console;

public class User {
	public User() {
	}

	public int input_money() {
		Message.INPUT_MONEY.print();

		try {
			int number = change_number(Console.readLine());

			return check_range(number);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}

	public List<Integer> winning_number() {
		Message.INPUT_WINNER_NUMBER.print();
		try {
			String[] win_numbers = Console.readLine().split(",");

			if (win_numbers.length != 6) {
				throw new IllegalArgumentException(Error_Message.INPUT_NUMBER_SIX.print_error());
			}

			List<Integer> numbers = new ArrayList<>();
			chagne_win_number_type(win_numbers, numbers);
			return numbers;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	private void chagne_win_number_type(String[] win_numbers, List<Integer> numbers) {
		try {
			boolean[] check = new boolean[46];
			for (int i = 0; i < win_numbers.length; i++) {
				int win_number = Integer.parseInt(win_numbers[i]);
				if (win_number < 1 || win_number > 45) {
					throw new IllegalArgumentException(Error_Message.INPUT_RANGE.print_error());
				}

				if (check[win_number]) {
					throw new IllegalArgumentException(Error_Message.INPUT_NUMBER_DISTINCT.print_error());
				}

				check[win_number] = true;
				numbers.add(win_number);
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(Error_Message.INPUT_NUMBER.print_error());
		}
	}

	public int winning_number_bonus() {
		Message.INPUT_BONUS_NUMBER.print();

		try {
			int bonus_input_number = Integer.parseInt(Console.readLine());

			if (bonus_input_number < 1 || bonus_input_number > 45) {
				throw new IllegalArgumentException(Error_Message.INPUT_RANGE.print_error());
			}

			return bonus_input_number;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}

	private static int check_range(int n) {
		if (n / 1000 == 0) {
			throw new IllegalArgumentException(Error_Message.INPUT_DIVIDE_TEN.print_error());
		}

		return n / 1000;
	}

	private int change_number(String input) {
		int number;
		try {
			number = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(Error_Message.INPUT_NUMBER.print_error());
		}
		return number;
	}
}
