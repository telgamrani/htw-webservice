package htw.service.request;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import htw.dao.model.json.LookJson;

public class AddLookRequest implements Serializable {
	
	private static final long serialVersionUID = -4018120410027743793L;
	
	@NotNull
	@Valid
	private LookJson look;
	
	public AddLookRequest() {}


	public AddLookRequest(LookJson look) {
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
		return "AddLookRequest [look=" + look + "]";
	}
	
	
}
