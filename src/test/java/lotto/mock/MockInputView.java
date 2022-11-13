package lotto.mock;

import lotto.view.InputViewImpl;

public class MockInputView extends InputViewImpl {

	public static final String MOCK_VALUE = "14000";

	@Override
	protected String readInput() {
		return MOCK_VALUE;
	}
}
