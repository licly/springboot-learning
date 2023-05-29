package org.charlie.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Charlie-6327
 * @date 2023/5/3
 */
public class ValidationBean {

    private static ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

    public static <T> Map<String, String> validate(T t, Class... groups) {
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<T>> result = validator.validate(t, groups);

        if (result.isEmpty()) {
            return Collections.emptyMap();
        } else {
            Map<String, String> errors = new LinkedHashMap<>();
            for (ConstraintViolation<T> violation : result) {
                errors.put(violation.getPropertyPath().toString(), violation.getMessage());
            }
            return errors;
        }
    }
}
