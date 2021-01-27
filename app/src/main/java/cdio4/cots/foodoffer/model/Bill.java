package cdio4.cots.foodoffer.model;

public class Bill {
    private String bill_id;
    private String bill_dateTime;
    private String bill_status;
    private Double bill_total;
    private String cus_id;
    private String res_id;


    public String getBill_id() {
        return bill_id;
    }

    public void setBill_id(String bill_id) {
        this.bill_id = bill_id;
    }

    public String getBill_dateTime() {
        return bill_dateTime;
    }

    public void setBill_dateTime(String bill_dateTime) {
        this.bill_dateTime = bill_dateTime;
    }

    public String getBill_status() {
        return bill_status;
    }

    public void setBill_status(String bill_status) {
        this.bill_status = bill_status;
    }

    public Double getBill_total() {
        return bill_total;
    }

    public void setBill_total(Double bill_total) {
        this.bill_total = bill_total;
    }

    public String getCus_id() {
        return cus_id;
    }

    public void setCus_id(String cus_id) {
        this.cus_id = cus_id;
    }

    public String getRes_id() {
        return res_id;
    }

    public void setRes_id(String res_id) {
        this.res_id = res_id;
    }

    public Bill(String bill_id, String bill_dateTime, String bill_status, Double bill_total, String cus_id, String res_id) {
        this.bill_id = bill_id;
        this.bill_dateTime = bill_dateTime;
        this.bill_status = bill_status;
        this.bill_total = bill_total;
        this.cus_id = cus_id;
        this.res_id = res_id;
    }

    public Bill() {
    }
}
