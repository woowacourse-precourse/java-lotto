package lotto.mock;

import lotto.view.InputViewImpl;

import java.util.Arrays;
import java.util.Iterator;

public class MockInputView extends InputViewImpl {
	public final Iterator<String> mockInputs;

	public MockInputView(String... mockInputs) {
		this.mockInputs = Arrays.stream(mockInputs).iterator();
	}

	@Override
	protected String readInput() {
		return mockInputs.next();
	}
}
