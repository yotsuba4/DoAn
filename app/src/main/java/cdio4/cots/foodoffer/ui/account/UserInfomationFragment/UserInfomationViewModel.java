package cdio4.cots.foodoffer.ui.account.UserInfomationFragment;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserInfomationViewModel extends AndroidViewModel {
    private MutableLiveData<String > fullname = new MutableLiveData<>();
    private MutableLiveData<Boolean> gender = new MutableLiveData<>();
    private MutableLiveData<String> bDate = new MutableLiveData<>();
    private MutableLiveData<String> usID = new MutableLiveData<>();
    private MutableLiveData<String> phone = new MutableLiveData<>();
    private MutableLiveData<String> email = new MutableLiveData<>();
    private MutableLiveData<String> adress = new MutableLiveData<>();

    public MutableLiveData<String> getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname.setValue(fullname);
    }

    public MutableLiveData<Boolean> getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender.setValue(gender);
    }

    public MutableLiveData<String> getbDate() {
        return bDate;
    }

    public void setbDate(String bDate) {
        this.bDate.setValue(bDate);
    }

    public MutableLiveData<String> getUsID() {
        return usID;
    }

    public void setUsID(String usID) {
        this.usID.setValue(usID);
    }

    public MutableLiveData<String> getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.setValue(phone);
    }

    public MutableLiveData<String> getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email.setValue(email);
    }

    public MutableLiveData<String> getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress.setValue(adress);
    }

    public UserInfomationViewModel(@NonNull Application application) {
        super(application);
    }
}