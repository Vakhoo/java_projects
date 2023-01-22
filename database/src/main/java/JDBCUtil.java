
public final class JDBCUtil {
    private static final String DB_URL = "jdbc:mysql://sql7.freesqldatabase.com:3306/sql7583723";
    private static final String DB_USER = "jdbc:mysql://sql7.freesqldatabase.com:3306/sql7583723";
    private static final String DB_PASSWORD = "jdbc:mysql://sql7.freesqldatabase.com:3306/sql7583723";

    private static Connection connection;
    private static Statment statment;

}

static {
        try{
        connection=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        }
        }

public static Statment getStatment(){
        if(statment == null){
            try{
                statment = conncection.createStatment();
        }.catch(SQLException e){
                throw ner RuntimeException(e);
        }
        }
        return statment;
        }
