package com.Q10Coffee;

public class Cashier {

        String cashierName;
        int CashId;
        public String getCashierName() {
            return cashierName;
        }
        public void setcashierName(String cashierName) {
            this.cashierName = cashierName;
        }

        public int getCashId() {
            return CashId;
        }
        public void setCashierId(int cashierId) {
            CashId = cashierId;
        }
        public void takeOrder(String cname)
        {
//cashier will take the order
        }
        public void giveTokenNo(String cname)
        {
//this will be called when customer places an order so cashier will provide him with a tokenno
        }
        public void receivePayment(int ctnum)
        {
//
        }
        public void addItToPendingQueue(int ctnum)
        {
        }
    }

