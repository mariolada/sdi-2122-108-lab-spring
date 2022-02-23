package com.uniovi.sdi_2122_108_spring.validators;
import com.uniovi.sdi_2122_108_spring.entities.Mark;
import com.uniovi.sdi_2122_108_spring.entities.User;
import com.uniovi.sdi_2122_108_spring.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.*;
@Component
public class MarkFormValidator implements Validator {
    @Autowired
    private UsersService usersService;
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }
    @Override
    public void validate(Object target, Errors errors) {
        Mark mark = (Mark) target;
        if (mark.getScore() < 0 || mark.getScore() > 10) {
            errors.rejectValue("score", "Error.mark.score.value");
        }
        if (mark.getDescription().length() < 20) {
            errors.rejectValue("score", "Error.mark.description.length");
        }
    }
    }

