package br.com.uniapp.validators;

import br.com.uniapp.exception.bundle.EmptyFieldException;
import br.com.uniapp.exception.bundle.UniException;
import br.com.uniapp.user.model.User;
import br.com.uniapp.utils.GeneralMessages;

public class UserValidator implements Validator<User>{

    @Override
    public void validateFields(User entity) throws UniException {
        if(entity.getPerson() == null) {
            throw new EmptyFieldException("Pessoa" + GeneralMessages.EMPTY_FIELD);
        } else if (entity.getEmail() == null) {
            throw new EmptyFieldException("Email" + GeneralMessages.EMPTY_FIELD);
        } else if (entity.getPassword() == null) {
            throw new EmptyFieldException("Senha" + GeneralMessages.EMPTY_FIELD);
        } else if (entity.getRole() == null) {
            throw new EmptyFieldException("Papel" + GeneralMessages.EMPTY_FIELD);
        }
    }
}
