package Models;

import Models.Enums.Statuses.PaymentStatus;
import Models.Enums.Types.PaymentModeType;

public class Payment {
    private Bill bill;
    private String txn_id;
    private PaymentModeType mode;
    private Double amount;
    private PaymentStatus status;

    public Payment(Bill bill, String txn_id, PaymentModeType mode, Double amount, PaymentStatus status) {
        this.bill = bill;
        this.txn_id = txn_id;
        this.mode = mode;
        this.amount = amount;
        this.status = status;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public String getTxn_id() {
        return txn_id;
    }

    public void setTxn_id(String txn_id) {
        this.txn_id = txn_id;
    }

    public PaymentModeType getMode() {
        return mode;
    }

    public void setMode(PaymentModeType mode) {
        this.mode = mode;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

}
