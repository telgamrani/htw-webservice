package htw.service.request;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import htw.dao.model.json.LookJson;

public class UpdateLookRequest implements Serializable {
	
	private static final long serialVersionUID = 1074312209381706343L;
	
	@NotNull
	@Valid
	private LookJson look;

	public UpdateLookRequest() {}

	public UpdateLookRequest(@NotNull @Valid LookJson look) {
		this.look = look;
	}

	public LookJson getLook() {
		return look;
	}

	public void setLook(LookJson look) {
		this.look = look;
	}

	@Override
	public String toString() {
		return "UpdateLookRequest [look=" + look + "]";
	}
	
}
