package br.com.uniapp.Person;

import br.com.uniapp.Enums.FrequentChurch;
import br.com.uniapp.Enums.Sex;
import br.com.uniapp.Enums.WeekDays;
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
