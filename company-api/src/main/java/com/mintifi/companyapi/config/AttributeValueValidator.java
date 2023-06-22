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
    // Assuming you have a repository for Attribute

    @Override
    public boolean isValid(CompanyAttributeValues attributeValue, ConstraintValidatorContext context) {
        String type = attributeValue.getType();
        String regex = attributeValue.getRegex();
        String value = attributeValue.getAttributeValue();

        if (type.equalsIgnoreCase("Type1")) {
            // Perform type-specific validation for Type1
            // For example, check if value is a valid integer
            try {
                Integer.parseInt(value);
            } catch (NumberFormatException e) {
                return false;
            }
        } else if (type.equalsIgnoreCase("Type2")) {
            // Perform type-specific validation for Type2
            // For example, check if value length is between 5 and 10 characters
            if (value.length() < 5 || value.length() > 10) {
                return false;
            }
        }

        // Perform regex validation if a regex is specified
        if (regex != null && !regex.isEmpty()) {
            Pattern pattern = Pattern.compile(regex);
            if (!pattern.matcher(value).matches()) {
                return false;
            }
        }

        return true;
    }
}
