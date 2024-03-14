package ra.entity;

import ra.run.BasicManagement;

import java.util.Date;
import java.util.Scanner;

public class Employee {
    private int employeeId;// - int (mã nhân viên , tự tăng)
    private String employeeName;// - String (tên nhân viên, không được để trống).
    private String email;// - String (địa chỉ gmail, đúng định dạng example@gmail.com, không trùng lặp)
    private String phoneNumber;// - String (số điện thoại, đúng định dạng số Việt nam, không trùng lặp)
    private String address;// - String (địa chỉ thường trú )
    private boolean enums;// (giới tính ,nhận 1 trong 3 giá trị MALE, FEMALE,    OTHER)
    private Date birthday;// - Date (ngày sinh, đinh dạng dd/MM/yyyy , không để trống)
    private float basicSalary; // - float (lương cơ bản, đơn vị $)
    private float allowanceSalary;//- float (phụ cấp, đơn vị $)
    private float rate; // - float (hệ số lương , phải >=1)
    private int departmentId;// - int (mã phòng ban làm việc , không được null)

    public Employee() {
    }

    public Employee(int employeeId, String employeeName, String email, String phoneNumber, String address, boolean enums, Date birthday, float basicSalary, float allowanceSalary, float rate, int departmentId) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.enums = enums;
        this.birthday = birthday;
        this.basicSalary = basicSalary;
        this.allowanceSalary = allowanceSalary;
        this.rate = rate;
        this.departmentId = departmentId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isEnums() {
        return enums;
    }

    public void setEnums(boolean enums) {
        this.enums = enums;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public float getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(float basicSalary) {
        this.basicSalary = basicSalary;
    }

    public float getAllowanceSalary() {
        return allowanceSalary;
    }

    public void setAllowanceSalary(float allowanceSalary) {
        this.allowanceSalary = allowanceSalary;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", enums=" + enums +
                ", birthday=" + birthday +
                ", basicSalary=" + basicSalary +
                ", allowanceSalary=" + allowanceSalary +
                ", rate=" + rate +
                ", departmentId=" + departmentId +
                '}';
    }

    public void inputEmployeeName(Scanner scanner){
        System.out.println("Nhập vào tên nhân viên: ");
        String inputEmployeeName;
       do {
            inputEmployeeName = scanner.nextLine();
            if (!inputEmployeeName.trim().isEmpty()){
                this.employeeName = inputEmployeeName;
                break;
            }else {
                System.err.println("Tên nhân viên không được để trống");
            }
        }while (true);
    }
//email;// - String (địa chỉ gmail, đúng định dạng example@gmail.com, không trùng lặp)
    public void inputEmail(Scanner scanner){
        System.out.println("Mời bạn nhập địa chỉ gmail");
        this.email = scanner.nextLine();
    }
    public void inputPhoneNumber(Scanner scanner){
        System.out.println("Mời bạn nhập số điện thoại");
        this.phoneNumber = scanner.nextLine();
    }
    public void inputAddress(Scanner scanner){
        System.out.println("Mời bạn nhập địa chỉ thường trú");
        this.address = scanner.nextLine();
    }
    public void enumsInput(Scanner scanner){
        System.out.println("Mời bạn nhập true giới tính nam và false cho giới tính nữ");
        this.enums = Boolean.parseBoolean(scanner.nextLine());
    }
    public void inputBirtday(Scanner scanner) {
        System.out.println("Mời bạn nhập ngày sinh");
        this.birthday = new Date();
    }
    public void inputBasicSalary(Scanner scanner){
        System.out.println("Mời bạn nhập lương cơ bản");
        this.basicSalary = Float.parseFloat(scanner.nextLine());
    }
    public void inputAllowanceSalaly(Scanner scanner){
        System.out.println("Mời bạn nhập phụ cấp lương");
        this.allowanceSalary = Float.parseFloat(scanner.nextLine());
    }
    public void inputRate(Scanner scanner){
        System.out.println("Mời bạn nhập hệ số lương");
        int rate;
        do {
            rate = Integer.parseInt(scanner.nextLine());
            if (rate>=1){
                this.rate = rate;
                break;
            }else {
                System.out.println("Hệ số lương lớn hơn hoặc bằng 1");
            }
        }while (true);
    }
public void inputDepatmentId(Scanner scanner){
    for (Department d: BasicManagement.departmentList){
        System.out.println(d.toString());
    }
    System.out.println("Mời bạn nhập DepatmentId ");
    int depatmentId;
    do {
        depatmentId = Integer.parseInt(scanner.nextLine());
        for (Department d: BasicManagement.departmentList){
            if (depatmentId == d.getDepartmentId()){
                this.departmentId = depatmentId;
                break;
            }else {
                System.out.println("DepatmentId không tồn tại yêu cầu nhập lại ");
            }
        }
    }while (true);
}
}

