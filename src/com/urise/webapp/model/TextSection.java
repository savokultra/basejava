package com.urise.webapp.model;

import javax.sql.rowset.spi.TransactionalWriter;
import java.io.Serial;
import java.util.Objects;

public class TextSection extends Section {
    @Serial
    private static final long serialVersionUID = 1L;

    private String content;

    public TextSection() {}

    public TextSection(String content) {
        Objects.requireNonNull(content, "content must not be null");
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return content;
    }

    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        TextSection that = (TextSection) o;

        return content.equals(that.content);
    }

    @Override
    public int hashCode() {
        return content.hashCode();
    }
}
