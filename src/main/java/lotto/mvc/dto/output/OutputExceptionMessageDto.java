package lotto.mvc.dto.output;

public final class OutputExceptionMessageDto {

    private final String exceptionMessage;

    public OutputExceptionMessageDto(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }
}
