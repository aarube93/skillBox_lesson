public class EmailAddress {
    private String email; //электронный адрес
    private String someData; /*Доп.информация для формирования письма.
    В примерах не используем — добавили, чтобы оправдать существование отдельного класса :)*/
    private boolean flag;

    public EmailAddress(String email,boolean flag,String someData) {
        this.email = email;
        this.someData = someData;
        this.flag = flag;
    }

    public EmailAddress(String email, boolean flag) {
        this.email = email;
        this.flag = flag;
    }

    public EmailAddress(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getSomeData() {
        return someData;
    }

    public void setSomeData(String someData) {
        this.someData = someData;
    }

    @Override
    public String toString() {
        return email;
    }
}