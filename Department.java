package ra.entity;

import ra.run.BasicManagement;

import java.util.Scanner;

public class Department {
    private int departmentId;// - int (mã phòng ban , tự tăng)
    private String departmentName; // - String (tên phòng ban, không được trùng

    public Department() {
    }

    public Department(int departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void inputDepartmentId() {
        if (!BasicManagement.departmentList.isEmpty()) {
            this.departmentId = BasicManagement.departmentList.get(BasicManagement.departmentList.size()).getDepartmentId() + 1;
        }else {
            this.departmentId = 1;
        }
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }

    public void inputDepartmentName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên các phòng ban:");
        String inputDepartmentName;
        while (true) {
            inputDepartmentName = scanner.nextLine();
            if (!inputDepartmentName.trim().isEmpty()) {
                for (Department d : BasicManagement.departmentList) {
                    if (!inputDepartmentName.equalsIgnoreCase(d.departmentName)) {
                        this.departmentName = inputDepartmentName;
                        System.out.println("Nhập thành công");
                        break;
                    } else {
                        System.err.println("Tên phòng ban đã bị trùng mời nhập lại!");
                    }
                }
            } else {
                System.err.println("Mời nhập tên phòng ban, không được để trống!");
            }

        }


    }
}
