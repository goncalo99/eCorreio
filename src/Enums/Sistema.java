package Enums;

public enum  Sistema {
    QUIT("A terminar."),
    INPUT_MISMATCH("Opcao inexistente.");

    private final String msg;

    Sistema(String msg) {
        this.msg = msg;
    }

    public String toString() {
        return msg;
    }
}
