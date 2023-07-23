package br.com.uniapp.validators;

import br.com.uniapp.exception.bundle.UniException;

public interface Validator <T> {

    void validateFields(T entity) throws UniException;
}
