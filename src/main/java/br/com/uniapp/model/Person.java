package br.com.uniapp.model;

import br.com.uniapp.model.enums.FrequentChurch;
import br.com.uniapp.model.enums.Sex;
import br.com.uniapp.model.enums.WeekDays;
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
    private Sex sex;

    private FrequentChurch frequentChurch;

    private WeekDays avaliableWeekDay;
}
