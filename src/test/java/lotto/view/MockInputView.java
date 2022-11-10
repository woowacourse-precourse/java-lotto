package lotto.view;

public class MockInputView extends InputViewImpl {

	public static final String MOCK_MONEY = "14000";

	@Override
	protected String readInput() {
		return MOCK_MONEY;
	}
}
