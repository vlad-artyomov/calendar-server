package com.artyomov.persistence.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * JPA class to store event.
 *
 * @author Vlad Artyomov
 * @since 08.03.2017, 8:53
 */
@Entity
@Table(name = "event")
@NamedQueries({
        @NamedQuery(name = Event.QUERY_ALL, query = "SELECT e FROM Event e")
})
public class Event extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 5112396377615933516L;

    public static final String QUERY_ALL = "Event.all";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "description")
    private String description;

    protected Event() {
    }

    public static class Builder {

        private Event event;

        public Builder() {
            event = new Event();
        }

        public Builder withDate(LocalDate date) {
            this.event.date = date;
            return this;
        }

        public Builder withDescription(String description) {
            this.event.description = description;
            return this;
        }

        public Event build() {
            return this.event;
        }
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public Long getId() {
        return id;
    }
}
