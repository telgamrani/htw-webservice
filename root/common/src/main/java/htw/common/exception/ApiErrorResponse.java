package htw.common.exception;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ApiErrorResponse {
	
	private Long timestamp;
	private HttpStatus status;
	private int errorCode;
	private String error;
    private String message;
    private String detail;
    private String path;  
    
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	
	public HttpStatus getStatus() {
		return status;
	}
	
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getError() {
		return error;
	}
	
	public void setError(String error) {
		this.error = error;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getDetail() {
		return detail;
	}
	
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
    
    // Builder
	public static final class ApiErrorResponseBuilder {
		
		private Long timestamp;
		private HttpStatus status;
		private int errorCode;
		private String error;
	    private String message;
	    private String detail;
	    private String path;
	    
		public ApiErrorResponseBuilder() {}
		
		public ApiErrorResponseBuilder withTimestamp(Long timestamp) {
			this.timestamp = timestamp;
			return this;
		}
	    
		public ApiErrorResponseBuilder withStatus(HttpStatus status) {
			this.status = status;
			return this;
		} 
	    
		public ApiErrorResponseBuilder withErrorCode(int errorCode) {
			this.errorCode = errorCode;
			return this;
		} 
	    
		public ApiErrorResponseBuilder withError(String error) {
			this.error = error;
			return this;
		} 
	    
		public ApiErrorResponseBuilder withMessage(String message) {
			this.message = message;
			return this;
		} 
	    
		public ApiErrorResponseBuilder withDetail(String detail) {
			this.detail = detail;
			return this;
		}
	    
		public ApiErrorResponseBuilder withPath(String path) {
			this.path = path;
			return this;
		} 
		
		public ApiErrorResponse build() {
			
			ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
			
			apiErrorResponse.timestamp = this.timestamp;
			apiErrorResponse.status = this.status;
			apiErrorResponse.errorCode = this.errorCode;
			apiErrorResponse.error = this.error;
			apiErrorResponse.message = this.message;
			apiErrorResponse.detail = this.detail;
			apiErrorResponse.path = this.path;
			
			return apiErrorResponse;
		}
	    
	}
    	
}
