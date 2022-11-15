package lotto.util;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.constant.LottoConstant;

public class Converter {
	public static String formatToMoneyForm(long Money) {
		DecimalFormat decimalFormat = new DecimalFormat("###,###");
		return decimalFormat.format(Money) + LottoConstant.TYPE_OF_CURRENCY;
	}

	public static List<Integer> convertStringWithCommaToIntegerList(String string) {
		return Arrays.stream(string.split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
	}
}
