package uce.edu.web.api.repository.modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    @Override
    public LocalDateTime unmarshal(String value) {
        return (value != null) ? LocalDateTime.parse(value, FORMATTER) : null;
    }

    @Override
    public String marshal(LocalDateTime value) {
        return (value != null) ? value.format(FORMATTER) : null;
    }
}