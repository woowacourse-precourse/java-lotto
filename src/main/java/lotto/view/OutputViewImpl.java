package lotto.view;

public class OutputViewImpl implements OutputView {

	public static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s";

	@Override
	public void printErrorMessage(Exception e) {
		System.out.println(String.format(ERROR_MESSAGE_FORMAT, e.getMessage()));
	}
}
