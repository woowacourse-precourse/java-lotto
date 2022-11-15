package lotto.domain.model;

import lotto.domain.ErrorMessage;

public class ExceptionHandler extends RuntimeException {

	public ExceptionHandler(ErrorMessage message) {
		super(message.getError_message());
	}

	public void tryCatch(ErrorMessage errorMessage){
		try {
			throw new IllegalArgumentException();
		} catch (IllegalArgumentException illegalArgumentException) {
			throw new ExceptionHandler(errorMessage);
		}
	}
}
