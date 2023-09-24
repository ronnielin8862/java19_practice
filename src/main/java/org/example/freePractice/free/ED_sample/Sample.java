package org.example.freePractice.free.ED_sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sample {


    public static void main(String[] args) {
        List<UserBasicInfo> userBasicInfoList = new ArrayList<>();

        List<StmMgrAuth> stmMgrAuthList = new ArrayList<>();


        Map userBasicMap = new HashMap();
        for (UserBasicInfo userBasicInfo: userBasicInfoList){
            StringBuilder builder = new StringBuilder();
            builder.append(userBasicInfo.departmentCode).append("/")
                    .append(userBasicInfo.EmployeeNo).append("/")
                    .append(userBasicInfo.postOaCode);
            userBasicMap.put(builder,"87");
        }

        for (StmMgrAuth stmMgrAuth:stmMgrAuthList){
            StringBuilder builder = new StringBuilder();
            builder.append(stmMgrAuth.departmentCode).append("/")
                    .append(stmMgrAuth.EmployeeNo).append("/")
                    .append(stmMgrAuth.postOaCode);
            if (userBasicMap.get(builder) != null){
//                doUpdate();
            }else {
//                doInsert();
            }
        }

    }


}


class UserBasicInfo{
    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getPostOaCode() {
        return postOaCode;
    }

    public void setPostOaCode(String postOaCode) {
        this.postOaCode = postOaCode;
    }

    public String getEmployeeNo() {
        return EmployeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        EmployeeNo = employeeNo;
    }

    String departmentCode;
    String postOaCode;
    String EmployeeNo;
}

class StmMgrAuth{
    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getPostOaCode() {
        return postOaCode;
    }

    public void setPostOaCode(String postOaCode) {
        this.postOaCode = postOaCode;
    }

    public String getEmployeeNo() {
        return EmployeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        EmployeeNo = employeeNo;
    }

    String departmentCode;
    String postOaCode;
    String EmployeeNo;
}