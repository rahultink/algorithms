
public class DefangIpAadress {

    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}