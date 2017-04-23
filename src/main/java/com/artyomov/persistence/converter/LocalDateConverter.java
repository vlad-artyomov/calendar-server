package com.artyomov.persistence.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author <a href="mailto:artyomov.dev@gmail.com">Vlad Artyomov</a>
 *         Date: 23.04.17
 *         Time: 17:20
 */
@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, String> {

    @Override
    public String convertToDatabaseColumn(LocalDate localDate) {
        if (null == localDate) {
            return null;
        }
        return localDate.format(DateTimeFormatter.ISO_DATE);
    }

    @Override
    public LocalDate convertToEntityAttribute(String s) {
        if (null == s) {
            return null;
        }
        return LocalDate.parse(s, DateTimeFormatter.ISO_DATE);
    }
}
