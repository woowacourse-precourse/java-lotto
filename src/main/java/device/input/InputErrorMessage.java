package device.input;

import device.message.Message;

public enum InputErrorMessage implements Message {
    NOT_FORM_CORRECT("[ERROR] 입력 형식이 올바르지 않습니다.");

    private String message;

    InputErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
