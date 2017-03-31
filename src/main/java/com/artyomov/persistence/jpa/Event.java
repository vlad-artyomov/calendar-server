package com.artyomov.persistence.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
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
//TODO add data source
public class Event implements Serializable {

    private static final long serialVersionUID = 5112396377615933516L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "date")
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
