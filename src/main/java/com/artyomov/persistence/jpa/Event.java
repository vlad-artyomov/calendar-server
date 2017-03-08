package com.artyomov.persistence.jpa;

import java.time.LocalDate;

/**
 * JPA class to store event.
 *
 * @author Vlad Artyomov
 * @since 08.03.2017, 8:53
 */
public class Event {

    private LocalDate date;

    private String description;

    private Event() {
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
}
