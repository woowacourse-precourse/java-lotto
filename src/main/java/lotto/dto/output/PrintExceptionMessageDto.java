package lotto.dto.output;

public class PrintExceptionMessageDto {

    private final String message;

    public PrintExceptionMessageDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
