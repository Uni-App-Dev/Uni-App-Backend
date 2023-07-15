package br.com.uniapp.Person;

import br.com.uniapp.Exception.bundle.EmptyFieldException;
import br.com.uniapp.Exception.bundle.UniException;
import br.com.uniapp.Person.model.Person;
import br.com.uniapp.Utils.GeneralMessages;

public class PersonValidator {

    public void validateFields(Person person) throws UniException {
        if(person.getName() == null){
            throw new EmptyFieldException("Nome" + GeneralMessages.EMPTY_FIELD);
        } else if (person.getPhone() == null) {
            throw new EmptyFieldException("Telefone" + GeneralMessages.EMPTY_FIELD);
        } else if (person.getSex() == null) {
            throw new EmptyFieldException("Sexo" + GeneralMessages.EMPTY_FIELD);
        } else if (person.getSmallGroupRole() == null) {
            throw new EmptyFieldException("Papel do PG" + GeneralMessages.EMPTY_FIELD);
        }
    }
}
