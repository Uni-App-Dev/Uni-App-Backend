package br.com.uniapp.validators;

import br.com.uniapp.exception.bundle.EmptyFieldException;
import br.com.uniapp.exception.bundle.UniException;
import br.com.uniapp.utils.GeneralMessages;
import br.com.uniapp.smallGroup.model.SmallGroup;

public class SmallGroupValidator implements Validator<SmallGroup>{

    @Override
    public void validateFields(SmallGroup entity) throws UniException {
        if(entity.getName() == null){
            throw new EmptyFieldException("Nome" + GeneralMessages.EMPTY_FIELD);
        } else if (entity.getWeekDay() == null) {
            throw new EmptyFieldException("Dia da semana" + GeneralMessages.EMPTY_FIELD);
        } else if (entity.getSex() == null) {
            throw new EmptyFieldException("Sexo" + GeneralMessages.EMPTY_FIELD);
        } else if (entity.getTime() == null) {
            throw new EmptyFieldException("Horário" + GeneralMessages.EMPTY_FIELD);
        }
    }
}
