package kr.yklee.springbootdemo.domain;

public class BaseResponse<T> {
		
	public BaseResponse() {
		
	}
	
	public BaseResponse(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	
	private int status;
	private String message;
	private T result;
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}
	
	
}
