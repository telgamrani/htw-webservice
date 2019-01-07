package htw.service.request;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import htw.dao.model.json.LookJson;

public class PublishLookRequest implements Serializable {

	private static final long serialVersionUID = -3971602614668036604L;

	@NotNull
	@Valid
	private LookJson look;
	
	@NotNull
	@Valid
	private boolean isPublished;

	public PublishLookRequest() {}

	public PublishLookRequest(@NotNull @Valid LookJson look, @NotNull @Valid boolean isPublished) {
		this.look = look;
		this.isPublished = isPublished;
	}

	public LookJson getLook() {
		return look;
	}

	public void setLook(LookJson look) {
		this.look = look;
	}

	public boolean isPublished() {
		return isPublished;
	}

	public void setIsPublished(boolean isPublished) {
		this.isPublished = isPublished;
	}
	
}
