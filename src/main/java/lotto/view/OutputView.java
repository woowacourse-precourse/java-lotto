package lotto.view;

import java.util.List;

import lotto.domain.LottoTicket;

public class OutputView {
	private static final String PRINT_LOTTO_NUMBER = "개를 구매했습니다.";

	public static void printLottoNumber(int lottoNumber) {
		System.out.println(lottoNumber + PRINT_LOTTO_NUMBER);
	}

	public static void printLottoTickets(List<List<Integer>> lottoTickets) {
		for (List<Integer> lottoTicket : lottoTickets) {
			StringBuilder lottoNumbers = new StringBuilder("[");
			for (Integer integer : lottoTicket) {
				lottoNumbers.append(integer).append(", ");
			}
			lottoNumbers.delete(lottoNumbers.length()-2, lottoNumbers.length());
			lottoNumbers.append("]");
			System.out.println(lottoNumbers);
		}
	}
 }
