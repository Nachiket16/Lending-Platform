package com.mintifi.companyapi.config;

import com.mintifi.companyapi.entity.CompanyAttributeValues;
import com.mintifi.companyapi.repository.CompanyAttributeRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;

public class AttributeValueValidator implements ConstraintValidator<ValidateAttributeValue, CompanyAttributeValues> {

    @Autowired
    private CompanyAttributeRepository companyAttributeRepository;

    @Override
    public void initialize(ValidateAttributeValue constraintAnnotation) {
        // No initialization required
    }
    @Override
    public boolean isValid(CompanyAttributeValues attributeValue, ConstraintValidatorContext context) {
        String type = attributeValue.getType();
        String regex = attributeValue.getRegex();
        String value = attributeValue.getAttributeValue();
        String error = attributeValue.getError();
        if (type.equalsIgnoreCase("Integer")) {
            try {
                Integer.parseInt(value);
            } catch (NumberFormatException e) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(error.isBlank()?"Value is not "
                    + "Number":error).addConstraintViolation();
                return false;
            }
        } else if (type.equalsIgnoreCase("String")) {
            if(value.isEmpty()){
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(error.isBlank()?"Value is not "
                    + "String":error).addConstraintViolation();
                return false;
            }
        }

        // Perform regex validation if a regex is specified


        if (regex != null && !regex.isEmpty()) {
            Pattern pattern = Pattern.compile(regex);
            if (!pattern.matcher(value).matches()) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(error!=null?error:"Invalid value").addConstraintViolation();
                return false;
            }
        }

        return true;
    }

    private String getErrorMessageFromAnnotation(ConstraintValidatorContext context) {
        return context.getDefaultConstraintMessageTemplate(); // Retrieves the error message from the annotation
    }
}
