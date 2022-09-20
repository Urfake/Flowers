package VariantB;

public class MegaCom {
        private String name;
        private int payment, parameter;

    public MegaCom(String name, int payment, int parameter) {
        this.name = name;
        this.payment = payment;
        this.parameter = parameter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public int getParameter() {
        return parameter;
    }

    public void setParameter(int parameter) {
        this.parameter = parameter;
    }
}
