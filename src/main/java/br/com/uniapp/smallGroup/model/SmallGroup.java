package br.com.uniapp.smallGroup.model;

import br.com.uniapp.Enums.Sex;
import br.com.uniapp.Enums.WeekDays;
import br.com.uniapp.Person.model.Person;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Collection;

@Entity
@Table(name="small_group", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SmallGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @NotNull
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private WeekDays weekDay;

    @NotNull
    private LocalTime time;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @NotNull
    @OneToMany(mappedBy = "smallGroupLead")
    private Collection<Person> leaders;

    @OneToMany(mappedBy = "smallGroup")
    private Collection<Person> members;
}
