package cdio4.cots.foodoffer.tools;

import com.google.android.material.textfield.TextInputLayout;

public class RegularExpression {
    public RegularExpression() {
    }

    public void checkNull(TextInputLayout textInputLayout, CharSequence charSequence, String errorMessage){
        if(charSequence.length() == 0)
            textInputLayout.setError(errorMessage);
        else
            textInputLayout.setError(null);
    }

    public void checkInputUsername(TextInputLayout textInputLayout, String input, String errorMessage){

    }

    public void checkInputPassword(TextInputLayout textInputLayout, String input, String errorMessage){

    }

    public void checkInputPasswordConfirm(TextInputLayout textInputLayout, String password ,String input, String errorMessage){

    }

    public void checkInputUserID(TextInputLayout textInputLayout, String password ,String input, String errorMessage){
        //Số cmnd/thẻ căn cước công dân
    }

    public void checkInputPhone(TextInputLayout textInputLayout,String input, String errorMessage){

    }

    public void checkInputEmail(TextInputLayout textInputLayout,String input, String errorMessage){

    }

}
