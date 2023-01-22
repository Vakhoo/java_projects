import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public final class JDBCUtil {

    private static final String DB_URL = "jdbc:mysql://sql7.freesqldatabase.com:3306/sql7583723";
    private static final String DB_USER = "sql7583723";
    private static final String DB_PASSWORD = "d1LUQ8I3MD";

    private static Connection connection;
    private static Statement statement;

    private  JDBCUtil() {

    }

    static {

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static Statement getStatement() {
        if(statement == null) {
            try {
                statement = connection.createStatement();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return statement;
    }

}

public class Main {

    public static void main(String[] args) {

        StudentUtils.getAllStudents()
                .stream()
                .forEach(student -> System.out.println(student));

        StudentUtils.updateStudent(2, "Kuuu");

        StudentUtils.getAllStudents()
                .stream()
                .forEach(student -> System.out.println(student));

    }

}

public class Student {

    private Long id;
    private String firstName;
    private String lastName;
    private Integer birthYear;

    public Student() {
    }

    public Student(Long id, String firstName, String lastName, Integer birthYear) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
    }

    public Student(String firstName, String lastName, Integer birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthYear=" + birthYear +
                '}';
    }

}

import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.util.ArrayList;
        import java.util.List;

public class StudentUtils {

    private StudentUtils() {
    }

    public static void createTable() {

        String createSql = "CREATE TABLE STUDENTS (" +
                "ID INTEGER NOT NULL AUTO_INCREMENT, " +
                "FIRST_NAME VARCHAR(255), " +
                "LAST_NAME VARCHAR(255)," +
                "BIRTH_YEAR INTEGER NOT NULL," +
                "PRIMARY KEY(ID))";

        try {
            JDBCUtil.getStatement().executeUpdate(createSql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Created table in given database...");

    }

    public static void insert(Student student) {

        String insertSql = "INSERT INTO STUDENTS(FIRST_NAME, LAST_NAME, BIRTH_YEAR) VALUES(" +
                "'" + student.getFirstName() + "', " +
                "'" + student.getLastName() + "', " +
                "" + student.getBirthYear() + ")";

        try {
            JDBCUtil.getStatement().executeUpdate(insertSql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static List<Student> getAllStudents() {

        String selectSql = "SELECT * FROM STUDENTS";

        List<Student> students = new ArrayList<>();

        try {

            ResultSet resultSet = JDBCUtil.getStatement().executeQuery(selectSql);

            while (resultSet.next()) {

                students.add(new Student(
                        resultSet.getLong("ID"),
                        resultSet.getString("FIRST_NAME"),
                        resultSet.getString("LAST_NAME"),
                        resultSet.getInt("BIRTH_YEAR")
                ));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return students;

    }

    public static void updateStudent(long id, String newFirstName) {

        String updateSql = "UPDATE STUDENTS SET FIRST_NAME = '" + newFirstName + "' WHERE ID = " + id;

        try {
            JDBCUtil.getStatement().executeUpdate(updateSql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void deleteStudent(long id) {

        String deleteAll = "DELETE FROM STUDENTS WHERE ID = " + id;

        try {
            JDBCUtil.getStatement().executeUpdate(deleteAll);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void deleteAll() {

        String deleteAll = "DELETE FROM STUDENTS";

        try {
            JDBCUtil.getStatement().executeUpdate(deleteAll);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
