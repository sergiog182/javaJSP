package Domain;

public class Client {
    private int clientId;
    private String name;
    private String lastname;
    private String email;
    private String phoneNumber;
    private double residue;

    public Client() {
    }

    public Client(int clientId) {
        this.clientId = clientId;
    }

    public Client(String name, String lastname, String email, String phoneNumber, double residue) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.residue = residue;
    }

    public Client(int clientId, String name, String lastname, String email, String phoneNumber, double residue) {
        this.clientId = clientId;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.residue = residue;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getResidue() {
        return residue;
    }

    public void setResidue(double residue) {
        this.residue = residue;
    }

    @Override
    public String toString() {
        return "Client{" + "clientId=" + clientId + ", name=" + name + ", lastname=" + lastname + ", email=" + email + ", phoneNumber=" + phoneNumber + ", residue=" + residue + '}';
    }
}
