package com.example.studentlistview;

import org.apache.commons.collections.Predicate;

import java.util.Comparator;


public class ModelStudent {

    private String name;
    private String number;
    private String department;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "ModelStudent{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    public ModelStudent() {
    }

    public ModelStudent(String name, String number, String department) {
        this.name       = name;
        this.number     = number;
        this.department = department;
    }

    // Name으로 정렬: comparator
    public static class NameCompare implements Comparator<ModelStudent> {
        // mode == 1 : 오름차순 정렬
        // mode == -1 : 내림차순 정렬
        private int mode = 1;

        public void setMode(boolean desc) {
            if( desc == true )
                this.mode = -1; // 내림차순 정렬
            else
                this.mode =  1; // 오름차순 정렬
        }

        public NameCompare() {
            mode = 1; //
        }

        public NameCompare(boolean desc) {
            this.setMode( desc );
        }

        // + 일 때 : 바꾼다.
        // 0 일 때 : 바꾸지 않는다.
        // - 일 때 : 바꾸지 않는다.
        @Override
        public int compare(ModelStudent o1, ModelStudent o2) {
            return o1.getName().compareTo( o2.getName() )*mode;
        }
    }

    // Number 로 정렬: comparator
    public static class NumberCompare implements Comparator<ModelStudent> {
        // mode == 1 : 오름차순 정렬
        // mode == -1 : 내림차순 정렬
        private int mode = 1;

        public void setMode(boolean desc) {
            if( desc == true )
                this.mode = -1; // 내림차순 정렬
            else
                this.mode =  1; // 오름차순 정렬
        }

        public NumberCompare() {
            this.mode = 1; //
        }

        public NumberCompare(boolean desc) {
            this.setMode(desc);
        }

        // + 일 때 : 바꾼다.
        // 0 일 때 : 바꾸지 않는다.
        // - 일 때 : 바꾸지 않는다.
        @Override
        public int compare(ModelStudent o1, ModelStudent o2) {
            return o1.getNumber().compareTo( o2.getNumber() )*mode;
        }
    }

    // Department 로 정렬: comparator
    public static class DeptCompare implements Comparator<ModelStudent> {
        // mode == 1 : 오름차순 정렬
        // mode == -1 : 내림차순 정렬
        private int mode = 1;

        public void setMode(boolean desc) {
            if( desc == true )
                this.mode = -1; // 내림차순 정렬
            else
                this.mode =  1; // 오름차순 정렬
        }
        public DeptCompare() {
            this.mode = 1; //
        }

        public DeptCompare(boolean desc) {
            this.setMode( desc );
        }

        // + 일 때 : 바꾼다.
        // 0 일 때 : 바꾸지 않는다.
        // - 일 때 : 바꾸지 않는다.
        @Override
        public int compare(ModelStudent o1, ModelStudent o2) {
            return o1.getDepartment().compareTo( o2.getDepartment() )*mode;
        }
    }


    // 검색: predicate
    /* Predicate를 사용하기 위해서는 build.gradle 에
     * compile 'commons-collections:commons-collections:3.+'
     * 를 추가해야 한다.
     */
    public static class MyPredicate implements Predicate {

        private String fieldName;
        private Object value;

        public MyPredicate(String fieldName, Object value) {
            this.fieldName = fieldName;
            this.value = value;
        }

        @Override
        public boolean evaluate(Object object) {
            if( fieldName.equals( "name" ) ) {
                return ((ModelStudent)object).getName().contains( value.toString() );
            }
            else if( fieldName.equals("number") ) {
                return ((ModelStudent)object).getNumber().contains( value.toString() );
            }
            else if( fieldName.equals("department") ){
                return ((ModelStudent)object).getDepartment().contains( value.toString() );
            }
            else {
                return false;
            }
        }
    }
}
