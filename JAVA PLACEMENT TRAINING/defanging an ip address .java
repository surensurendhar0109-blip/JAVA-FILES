class defanging an ip address {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}