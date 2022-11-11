package lotto;

public class Status {
	public String status;

	Status() {
		initStatus();
	}

	public void initStatus() {
		status = "ready";
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}
