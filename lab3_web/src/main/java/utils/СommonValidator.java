package utils;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class СommonValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        FacesMessage message = new FacesMessage();
        if(o.toString().length() ==0){
            message.setSummary("Вы ничего не ввели");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }

        else if(!Utils.isNumeric(o.toString())){
            message.setSummary("Введите число");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
        else if(!validateRange(Float.parseFloat(o.toString()))){
            message.setSummary("Допустимый диапазон (-5..5)");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }

    public boolean validateRange(float value) {
        if (value > -5 && value < 5) {
            return true;
        }
        return false;
    }
}
