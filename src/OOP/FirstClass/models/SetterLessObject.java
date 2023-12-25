package OOP.FirstClass.models;

public class SetterLessObject {
    String Address,Street,Name,Email;
    int Phone,HouseNo;
    public SetterLessObject(String Address,String Street,String Name,String Email,int Phone,int HouseNo){
        this.Address=Address;
        this.Street=Street;
        this.Name=Name;
        this.Phone=Phone;
        this.HouseNo=HouseNo;
    }

    public String getAddress() {
        return Address;
    }

    public String getStreet() {
        return Street;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }

    public int getPhone() {
        return Phone;
    }

    public int getHouseNo() {
        return HouseNo;
    }

    public void displayOrder(){
        String userName=this.Name;
        String userAddress=this.Address;
        String userStreet=this.Street;
        String userEmail=this.Email;
        int userHouse=this.HouseNo;
        int userPhone=this.Phone;
        String DisplayInformation="This order is from "+userName+" and they live in "+userAddress+", "+ userStreet+" house number "+userHouse+" and their Phone Number is "+userPhone;
        System.out.println(DisplayInformation);
    }
}
