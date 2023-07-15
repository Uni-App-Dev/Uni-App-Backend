package br.com.uniapp.smallGroup;

import br.com.uniapp.Exception.bundle.EmptyFieldException;
import br.com.uniapp.Exception.bundle.UniException;
import br.com.uniapp.Utils.GeneralMessages;
import br.com.uniapp.smallGroup.model.SmallGroup;

public class SmallGroupValidator {

    public void validateFields(SmallGroup smallGroup) throws UniException {
        if(smallGroup.getName() == null){
            throw new EmptyFieldException("Nome" + GeneralMessages.EMPTY_FIELD);
        } else if (smallGroup.getWeekDay() == null) {
            throw new EmptyFieldException("Dia da semana" + GeneralMessages.EMPTY_FIELD);
        } else if (smallGroup.getSex() == null) {
            throw new EmptyFieldException("Sexo" + GeneralMessages.EMPTY_FIELD);
        } else if (smallGroup.getTime() == null) {
            throw new EmptyFieldException("Horário" + GeneralMessages.EMPTY_FIELD);
        }
    }
}
