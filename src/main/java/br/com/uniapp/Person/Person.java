package br.com.uniapp.Person;

import br.com.uniapp.Enums.FrequentChurch;
import br.com.uniapp.Enums.Sex;
import br.com.uniapp.Enums.WeekDays;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank
    private String name;

    @NotBlank
    private String phone;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Enumerated(EnumType.STRING)
    private FrequentChurch frequentChurch;

    @Enumerated(EnumType.STRING)
    private WeekDays avaliableWeekDay;
}
