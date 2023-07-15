package br.com.uniapp.Person.model;

import br.com.uniapp.Enums.FrequentChurch;
import br.com.uniapp.Enums.Sex;
import br.com.uniapp.Enums.SmallGroupRole;
import br.com.uniapp.Enums.WeekDays;
import br.com.uniapp.smallGroup.model.SmallGroup;
import br.com.uniapp.smallGroup.model.SmallGroupDto;
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
