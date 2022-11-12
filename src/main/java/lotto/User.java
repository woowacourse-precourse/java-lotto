package lotto;

import camp.nextstep.edu.missionutils.Console;

public class User {

	public static void main(String[] args) {

		int payment = getPayment();
		System.out.println(payment);
	}

	public static int getPayment() {

		int payment;

		System.out.println("구입금액을 입력해 주세요.");
		try {
			payment = Integer.parseInt(Console.readLine());

			checkPaymentUnit(payment);
		}

		catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
		}

		return payment;
	}

	public static void checkPaymentUnit(int payment) {

		boolean isThousandUnits = payment % 1000 == 0;

		if (!isThousandUnits) {
			throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해야 합니다.");
		}
	}
}