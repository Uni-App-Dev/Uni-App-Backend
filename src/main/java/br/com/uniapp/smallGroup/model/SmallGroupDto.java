package br.com.uniapp.smallGroup.model;

import br.com.uniapp.enums.Sex;
import br.com.uniapp.enums.WeekDays;
import br.com.uniapp.person.model.PersonOutputDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SmallGroupDto {

    private long Id;
    private String name;
    private WeekDays weekDay;
    private LocalTime time;
    private Sex sex;
    private Collection<PersonOutputDto> members;
}
