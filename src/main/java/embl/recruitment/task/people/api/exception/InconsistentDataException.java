package embl.recruitment.task.people.api.exception;

import org.springframework.http.HttpStatus;

public class InconsistentDataException extends ApiServiceException{

	private static final long serialVersionUID = -5706973495569643080L;
	private static final String MESSAGE = "Unconsistant data was provided for resource '%s' throw '%s' property";
	
	public InconsistentDataException(String resourceName, String propertyName) {
		super(String.format(MESSAGE, resourceName,propertyName));
	}

	@Override
	public HttpStatus getErrorHttpStatus() {
		return HttpStatus.BAD_REQUEST;
	}

}
