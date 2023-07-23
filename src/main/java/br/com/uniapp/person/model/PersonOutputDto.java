package br.com.uniapp.person.model;

import br.com.uniapp.enums.FrequentChurch;
import br.com.uniapp.enums.Sex;
import br.com.uniapp.enums.SmallGroupRole;
import br.com.uniapp.enums.WeekDays;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonOutputDto {

    private Long id;
    private String name;
    private String phone;
    private Sex sex;
    private FrequentChurch frequentChurch;
    private WeekDays avaliableWeekDay;
    private SmallGroupRole smallGroupRole;
}
