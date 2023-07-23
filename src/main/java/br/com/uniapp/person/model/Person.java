package br.com.uniapp.person.model;

import br.com.uniapp.enums.FrequentChurch;
import br.com.uniapp.enums.Sex;
import br.com.uniapp.enums.SmallGroupRole;
import br.com.uniapp.enums.WeekDays;
import br.com.uniapp.smallGroup.model.SmallGroup;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="person", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @NotNull
    private String name;

    @NotNull
    private String phone;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Enumerated(EnumType.STRING)
    private FrequentChurch frequentChurch;

    @Enumerated(EnumType.STRING)
    private WeekDays avaliableWeekDay;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "small_group_id")
    private SmallGroup smallGroup;

    @Enumerated(EnumType.STRING)
    @NotNull
    private SmallGroupRole smallGroupRole;
}
