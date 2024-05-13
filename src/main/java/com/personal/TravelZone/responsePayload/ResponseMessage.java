package com.personal.TravelZone.responsePayload;

public class ResponseMessage {
	String message;
	boolean status;
	
	public ResponseMessage() {
	}

	public ResponseMessage(String message, boolean status) {
		this.message = message;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ResponseMessage [message=" + message + ", status=" + status + "]";
	}
	
}
