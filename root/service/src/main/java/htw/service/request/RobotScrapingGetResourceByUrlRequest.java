package htw.service.request;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class RobotScrapingGetResourceByUrlRequest implements Serializable {
	
	private static final long serialVersionUID = 7329555849359028250L;
	
	@NotNull
	@Valid
	private String url;

	public RobotScrapingGetResourceByUrlRequest() {}

	public RobotScrapingGetResourceByUrlRequest(@NotNull @Valid String url) {
		super();
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
	
	
}
