package com.artyomov.persistence.dto;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

/**
 * @author <a href="mailto:artyomov.dev@gmail.com">Vlad Artyomov</a>
 *         Date: 08.03.17
 *         Time: 11:14
 */
@XmlRootElement
public class EventInfo {

    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    private LocalDate date;

    private String description;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
