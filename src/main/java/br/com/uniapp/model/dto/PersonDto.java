package br.com.uniapp.model.dto;

import br.com.uniapp.model.enums.FrequentChurch;
import br.com.uniapp.model.enums.Sex;
import br.com.uniapp.model.enums.WeekDays;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {

    private Long id;
    private String name;
    private String phone;
    private Sex sex;
    private FrequentChurch frequentChurch;
    private WeekDays avaliableWeekDay;
}
