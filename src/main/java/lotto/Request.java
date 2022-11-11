package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Request {

	private String userInput;

	public Request() {}

	public void requestUserInput() {
		userInput = Console.readLine();
	}

}
