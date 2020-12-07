class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        if (firstName != null) {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {
        if (lastName != null) {
            this.lastName = lastName;
        }
    }

    public String getFullName() {
        if ("".equals(this.firstName) && "".equals(this.lastName)) {
            return "Unknown";
        } else if ("".equals(this.firstName)) {
            return this.lastName;
        } else if ("".equals(this.lastName)) {
            return this.firstName;
        }
        return this.firstName + " " + this.lastName; // write your code here
    }
}