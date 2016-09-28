package main.java.br.com.mesquitagomes.model.validation;

import java.util.List;

public abstract class Validator {

	abstract public boolean supports(Class<?> cls);

	abstract public void validate(Object obj, List<String> errors);

}
