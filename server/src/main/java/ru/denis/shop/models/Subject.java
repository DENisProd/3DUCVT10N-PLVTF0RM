package ru.denis.shop.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.denis.shop.payload.request.SubjectCreateRequest;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String name;
    @Enumerated
    public ESubject passType = ESubject.TYPE_OFFSET;

    public Subject (String name, ESubject passType) {
        this.name = name;
        this.passType = passType;
    }
}
