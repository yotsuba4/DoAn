package cdio4.cots.foodoffer.model;

public class Account {
    private String mAcc_fullName;
    private Boolean mAcc_gender;
    private String mAcc_bDate;
    private String mAcc_ID;
    private String mAcc_phone;
    private String mAcc_email;
    private String mAcc_adress;

    public String getmAcc_fullName() {
        return mAcc_fullName;
    }

    public void setmAcc_fullName(String mAcc_fullName) {
        this.mAcc_fullName = mAcc_fullName;
    }

    public Boolean getmAcc_gender() {
        return mAcc_gender;
    }

    public void setmAcc_gender(Boolean mAcc_gender) {
        this.mAcc_gender = mAcc_gender;
    }

    public String getmAcc_bDate() {
        return mAcc_bDate;
    }

    public void setmAcc_bDate(String mAcc_bDate) {
        this.mAcc_bDate = mAcc_bDate;
    }

    public String getmAcc_ID() {
        return mAcc_ID;
    }

    public void setmAcc_ID(String mAcc_ID) {
        this.mAcc_ID = mAcc_ID;
    }

    public String getmAcc_phone() {
        return mAcc_phone;
    }

    public void setmAcc_phone(String mAcc_phone) {
        this.mAcc_phone = mAcc_phone;
    }

    public String getmAcc_email() {
        return mAcc_email;
    }

    public void setmAcc_email(String mAcc_email) {
        this.mAcc_email = mAcc_email;
    }

    public String getmAcc_adress() {
        return mAcc_adress;
    }

    public void setmAcc_adress(String mAcc_adress) {
        this.mAcc_adress = mAcc_adress;
    }

    public Account(String mAcc_fullName, Boolean mAcc_gender, String mAcc_bDate,
                   String mAcc_ID, String mAcc_phone, String mAcc_email, String mAcc_adress) {
        this.mAcc_fullName = mAcc_fullName;
        this.mAcc_gender = mAcc_gender;
        this.mAcc_bDate = mAcc_bDate;
        this.mAcc_ID = mAcc_ID;
        this.mAcc_phone = mAcc_phone;
        this.mAcc_email = mAcc_email;
        this.mAcc_adress = mAcc_adress;
    }

    public Account() {
    }
}
