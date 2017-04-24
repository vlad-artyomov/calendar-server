package com.artyomov.persistence.dto;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;

/**
 * @author <a href="mailto:artyomov.dev@gmail.com">Vlad Artyomov</a>
 *         Date: 08.03.17
 *         Time: 11:18
 */
public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

    @Override
    public LocalDate unmarshal(String v) throws Exception {
        return LocalDate.parse(v);
    }

    @Override
    public String marshal(LocalDate v) throws Exception {
        return v.toString();
    }
}
