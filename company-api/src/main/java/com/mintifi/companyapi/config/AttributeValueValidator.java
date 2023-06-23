package com.mintifi.companyapi.config;

import com.mintifi.companyapi.entity.CompanyAttributeValues;
import com.mintifi.companyapi.repository.AttributeRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;

public class AttributeValueValidator implements ConstraintValidator<ValidateAttributeValue, CompanyAttributeValues> {

    @Autowired
    private AttributeRepository attributeRepository;

    @Override
    public boolean isValid(CompanyAttributeValues attributeValue, ConstraintValidatorContext context) {
        String type = attributeValue.getType();
        String regex = attributeValue.getRegex();
        String value = attributeValue.getAttributeValue();

        if (type.equalsIgnoreCase("Integer")) {
            try {
                Integer.parseInt(value);
            } catch (NumberFormatException e) {
                return false;
            }
        } else if (type.equalsIgnoreCase("String")) {
            if(value.isEmpty()){
                return false;
            }
        }

        // Perform regex validation if a regex is specified
        if (regex != null && !regex.isEmpty()) {
            Pattern pattern = Pattern.compile(regex);
            boolean matches = Pattern.matches(regex, value);
            return matches;
        }

        return true;
    }
}
