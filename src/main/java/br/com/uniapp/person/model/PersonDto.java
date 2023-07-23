package br.com.uniapp.person.model;

import br.com.uniapp.enums.FrequentChurch;
import br.com.uniapp.enums.Sex;
import br.com.uniapp.enums.SmallGroupRole;
import br.com.uniapp.enums.WeekDays;
import br.com.uniapp.smallGroup.model.SmallGroupOutputDto;
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
    private SmallGroupOutputDto smallGroup;
    private SmallGroupRole smallGroupRole;
}
