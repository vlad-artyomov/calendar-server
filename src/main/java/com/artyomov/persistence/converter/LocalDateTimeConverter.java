package com.artyomov.persistence.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author <a href="mailto:artyomov.dev@gmail.com">Vlad Artyomov</a>
 *         Date: 23.04.17
 *         Time: 17:21
 */
@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, String> {

    @Override
    public String convertToDatabaseColumn(LocalDateTime localDateTime) {
        if (null == localDateTime) {
            return null;
        }
        return localDateTime.format(DateTimeFormatter.ISO_DATE_TIME);
    }

    @Override
    public LocalDateTime convertToEntityAttribute(String s) {
        if (null == s) {
            return null;
        }
        return LocalDateTime.parse(s, DateTimeFormatter.ISO_DATE_TIME);
    }
}