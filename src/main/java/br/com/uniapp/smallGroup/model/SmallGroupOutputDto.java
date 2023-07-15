package br.com.uniapp.smallGroup.model;

import br.com.uniapp.Enums.Sex;
import br.com.uniapp.Enums.WeekDays;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SmallGroupOutputDto {

    private long Id;
    private String name;
    private WeekDays weekDay;
    private LocalTime time;
    private Sex sex;
}
