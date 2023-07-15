package br.com.uniapp.User;

import br.com.uniapp.Exception.bundle.EmptyFieldException;
import br.com.uniapp.Exception.bundle.UniException;
import br.com.uniapp.User.model.User;
import br.com.uniapp.Utils.GeneralMessages;

public class UserValidator {

    public void validateFields(User user) throws UniException {
        if(user.getPerson() == null) {
            throw new EmptyFieldException("Pessoa" + GeneralMessages.EMPTY_FIELD);
        } else if (user.getEmail() == null) {
            throw new EmptyFieldException("Email" + GeneralMessages.EMPTY_FIELD);
        } else if (user.getPassword() == null) {
            throw new EmptyFieldException("Senha" + GeneralMessages.EMPTY_FIELD);
        } else if (user.getRole() == null) {
            throw new EmptyFieldException("Papel" + GeneralMessages.EMPTY_FIELD);
        }
    }
}
