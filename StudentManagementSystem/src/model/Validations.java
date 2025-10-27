package model;

public class Validations {
    public static boolean idValidation(String id){
        int idd = Integer.parseInt(id.trim());
        if(id.trim().isEmpty()){
            return false;
        }
        else if(idd <= 0){
            return false;
        }else if(!id.matches("^[0-9]+$")){
            return false;
        }
        return true;
    }

    public static boolean nameValidation(String name){
        if(name.trim().isEmpty()){
            return false;
        }else if(! name.matches("[a-zA-Z ]+")){
            return false;
        }
        return true;
    }

    public static boolean ageValidation(String age) {
        int agee = Integer.parseInt(age.trim());
        if(age.trim().isEmpty()){
            return false;
        }else if(agee <= 15 || agee > 100){
            return false;
        }else if(!age.matches("^[0-9]+$")){
            return false;
        }
        return true;
    }

    public static boolean gendervalidation(String gender){
        if(gender == null || gender.equals("Select Gender")){
            return false;
        }
        return true;
    }

    public static boolean gpaValidation(String gpa){
        double gpaa = Double.parseDouble(gpa.trim());
        if(gpa.trim().isEmpty()){
            return false;
        }else if(gpaa < 0.0 || gpaa > 4.0){
            return false;
        }
        return true;
    }

    public static boolean departmentValidation(String department){
        if(department.trim().isEmpty()){
            return false;
        }
        return true;
    }
}
