package phoneBook;

public class PhoneBook {
    private String PhoneName;
    private String PhoneNumber;
    private String PhoneGroup;
    private String Email;
    private String sex;
    private String Address;
    private String birthDay;

    public PhoneBook() {
    }

    public PhoneBook(String phoneName, String phoneNumber, String phoneGroup, String email, String sex, String address, String birthDay) {
        PhoneName = phoneName;
        PhoneNumber = phoneNumber;
        PhoneGroup = phoneGroup;
        Email = email;
        this.sex = sex;
        Address = address;
        this.birthDay = birthDay;
    }

    public String getPhoneName() {
        return PhoneName;
    }

    public void setPhoneName(String phoneName) {
        PhoneName = phoneName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getPhoneGroup() {
        return PhoneGroup;
    }

    public void setPhoneGroup(String phoneGroup) {
        PhoneGroup = phoneGroup;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }
    public String toString() {
        return
               this.PhoneName +
               ","  + this.PhoneNumber +
                "," + this.PhoneGroup +
                "," + this.Email +
                "," + this.sex +
                "," + this.Address +
                "," + this.birthDay;
    }
}
