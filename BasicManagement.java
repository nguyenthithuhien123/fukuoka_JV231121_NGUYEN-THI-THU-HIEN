package ra.run;

import ra.entity.Department;
import ra.entity.Employee;

import java.util.*;

public class BasicManagement {
    public static List<Department> departmentList = new ArrayList<>();
    public static List<Employee> employeeList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        do {
            menu();
            System.out.println("Lựa chọn của bạn:");
            int chose;
            try {
                chose = Integer.parseInt(scanner.nextLine());
                switch (chose) {
                    case 1:
                        departmenMenu();
                        System.out.println("Lựa chọn của bạn: ");
                        int chose2;
                        try {
                            chose2 = Integer.parseInt(scanner.nextLine());
                            switch (chose2) {
                                case 1:
                                    System.out.println("Mời bạn nhập số phòng ban cần thêm");
                                    int departmentNum;
                                    do {
                                        try {
                                            departmentNum = Integer.parseInt(scanner.nextLine());
                                            if (departmentNum > 0) {
                                                for (int i = 0; i < departmentNum; i++) {
                                                    Department department = new Department();
                                                    department.inputDepartmentId();
                                                    department.inputDepartmentName();
                                                    departmentList.add(department);
                                                }
                                                break;
                                            }
                                        } catch (Exception e) {
                                            System.err.println("Mời nhập số nguyên dương");
                                        }
                                    } while (true);
                                    break;
                                case 2:
                                    for (Department d : departmentList) {
                                        System.out.println(d.toString());
                                    }
                                    break;
                                case 3:
                                    System.out.println("Nhập Id phòng ban cần sửa:");
                                    int id = Integer.parseInt(scanner.nextLine());
                                    if (checkIdDepartment(id) >= 0) {
                                        departmentList.get(checkIdDepartment(id)).setDepartmentId(id);
                                    } else {
                                        System.out.println("Id không tồn tại");
                                    }
                                    break;
                                case 4:
                                    System.out.println("Nhập Id cần xóa");
                                    int deleteId = Integer.parseInt(scanner.nextLine());
                                    if (checkIdDepartment(deleteId) >= 0) {
                                        departmentList.remove(checkIdDepartment(deleteId));
                                    } else {
                                        System.out.println("Id không tồn tại");
                                    }
                                    break;
                                case 5:
                                    System.out.println("Nhập Id phòng ban cần tìm kiếm ");
                                    int seachId = Integer.parseInt(scanner.nextLine());
                                    if (checkIdDepartment(seachId) >= 0) {
                                        System.out.println(departmentList.get(checkIdDepartment(seachId)).toString());
                                    } else {
                                        System.out.println("Id không tồn tại");
                                    }
                                    break;
                                case 0:
                                    break;
                                default:
                                    System.err.println("Mời bạn nhập từ 0-5");

                            }
                        } catch (Exception e) {
                            System.err.println("Mời nhập từ 0-5");
                        }
                        break;
                    case 2:
                        employeeMenu();
                        System.out.println("Lựa chọn của bạn ");
                        int chose3;
                        do {
                            try {
                                chose3 = Integer.parseInt(scanner.nextLine());
                                switch (chose3) {
                                    case 1:
                                        System.out.println("Mời bạn nhập số nhân viên cần thêm");
                                        int employeeNum = Integer.parseInt(scanner.nextLine());
                                        for (int i = 0; i < employeeNum; i++) {
                                            Employee employee = new Employee();
                                            if (employeeList == null) {
                                                employee.setEmployeeId(1);
                                            } else {
                                                employee.setEmployeeId(employeeList.get(employeeList.size()).getEmployeeId() + 1);
                                            }
                                            employee.inputEmployeeName(scanner);
                                            employee.inputEmail(scanner);
                                            employee.inputPhoneNumber(scanner);
                                            employee.inputAddress(scanner);
                                            employee.enumsInput(scanner);
                                            employee.inputBirtday(scanner);
                                            employee.inputBasicSalary(scanner);
                                            employee.inputAllowanceSalaly(scanner);
                                            employee.inputRate(scanner);
                                            employee.inputDepatmentId(scanner);
                                            employeeList.add(employee);
                                        }
                                        break;
                                    case 2:
                                        for (Employee e : employeeList) {
                                            System.out.println(e.toString());
                                        }
                                        break;
                                    case 3:
                                        System.out.println("Nhập id nhân viên cần xem:");
                                        int id = Integer.parseInt(scanner.nextLine());
                                        if (checkIdEmployee(id) >= 0) {
                                            System.out.println(employeeList.get(checkIdEmployee(id)).toString());
                                        } else {
                                            System.out.println("Id không tồn tại");
                                        }
                                        break;
                                    case 4:
                                        System.out.println("Nhập id nhân viên cần thay đổi:");
                                        int updateId = Integer.parseInt(scanner.nextLine());
                                        if (checkIdEmployee(updateId) >= 0) {

                                            employeeList.get(checkIdEmployee(updateId)).inputEmployeeName(scanner);
                                            employeeList.get(checkIdEmployee(updateId)).inputEmail(scanner);
                                            employeeList.get(checkIdEmployee(updateId)).inputPhoneNumber(scanner);
                                            employeeList.get(checkIdEmployee(updateId)).inputAddress(scanner);
                                            employeeList.get(checkIdEmployee(updateId)).enumsInput(scanner);
                                            employeeList.get(checkIdEmployee(updateId)).inputBirtday(scanner);
                                            employeeList.get(checkIdEmployee(updateId)).inputBasicSalary(scanner);
                                            employeeList.get(checkIdEmployee(updateId)).inputAllowanceSalaly(scanner);
                                            employeeList.get(checkIdEmployee(updateId)).inputRate(scanner);
                                            employeeList.get(checkIdEmployee(updateId)).inputDepatmentId(scanner);
                                        } else {
                                            System.out.println("Id không tồn tại");
                                        }
                                        break;
                                    case 5:
                                        System.out.println("Nhập thông tin nhân viên cần xóa");
                                        int deleteId = Integer.parseInt(scanner.nextLine());
                                        if (checkIdEmployee(deleteId) >= 0) {
                                            employeeList.remove(checkIdEmployee(deleteId));
                                        } else {
                                            System.out.println("Id không tồn tại");
                                        }
                                        break;
                                    case 6:

                                        break;
                                    case 7:
                                        Collections.sort(employeeList, new Comparator<Employee>() {
                                            @Override
                                            public int compare(Employee o1, Employee o2) {
                                                return o1.getDepartmentId() - o2.getDepartmentId();
                                            }
                                        });
                                        for (Employee e : employeeList) {
                                            System.out.println(e.toString());
                                        }
                                        break;
                                    case 0:
                                        break;
                                    default:
                                        System.err.println("Mời nhập từ 0-7");
                                }
                            } catch (Exception e) {
                                System.err.println("Mời bạn nhập từ 0-7");
                            }
                            break;
                        }while (true);

                    case 3:
                        System.exit(0);
                    default:
                        System.err.println("Mời nhập số nguyên từ 1-3");
                }
            } catch (Exception e) {
                System.err.println("Sai định dạng, yêu cầu nhập lại");
            }
        } while (true);
    }

    public static void menu() {
        System.out.println("""
                *********************************MENU*******************************
                1. Quản lý phòng ban
                2. Quản lý nhân viên
                3. Thoát chương trình
                """);
    }

    public static void departmenMenu() {
        System.out.println("""
                **********************DEPARTMENT-MENU************************
                1. Thêm mới phòng ban 
                2. Hiển thị thông tin tất cả phòng ban 
                3. Sửa tên phòng ban 
                4. Xóa phòng ban 
                5. Tìm kiếm phòng ban 
                0. Quay lại
                                
                """);
    }

    public static void employeeMenu() {
        System.out.println("""
                *************************EMPLOYEE-MENU**************************
                1. Thêm mới nhân viên
                2. Hiển thị thông tin tất cả nhân viên 
                3. Xem chi tiết thông tin nhân viên
                4. Thay đổi thông tin nhân viên
                5. Xóa nhân viên
                6. Hiển thị danh sách nhân viên theo phòng ban
                7. Sắp xếp danh sách nhân viên
                0. Quay lại
                                
                """);
    }

    public static int checkIdDepartment(int id) {
        Scanner scanner = new Scanner(System.in);
        id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < departmentList.size(); i++) {
            if (id == departmentList.get(i).getDepartmentId()) {
                return i;
            }
        }
        return -1;
    }

    public static int checkIdEmployee(int id) {
        Scanner scanner = new Scanner(System.in);
        id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < employeeList.size(); i++) {
            if (id == employeeList.get(i).getEmployeeId()) {
                return i;
            }
        }
        return -1;
    }
}
