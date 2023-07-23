package br.com.uniapp.validators;

import br.com.uniapp.exception.bundle.EmptyFieldException;
import br.com.uniapp.exception.bundle.UniException;
import br.com.uniapp.person.model.Person;
import br.com.uniapp.utils.GeneralMessages;

public class PersonValidator implements Validator<Person>{

    @Override
    public void validateFields(Person entity) throws UniException {
        if(entity.getName() == null){
            throw new EmptyFieldException("Nome" + GeneralMessages.EMPTY_FIELD);
        } else if (entity.getPhone() == null) {
            throw new EmptyFieldException("Telefone" + GeneralMessages.EMPTY_FIELD);
        } else if (entity.getSex() == null) {
            throw new EmptyFieldException("Sexo" + GeneralMessages.EMPTY_FIELD);
        } else if (entity.getSmallGroupRole() == null) {
            throw new EmptyFieldException("Papel do PG" + GeneralMessages.EMPTY_FIELD);
        }
    }
}
