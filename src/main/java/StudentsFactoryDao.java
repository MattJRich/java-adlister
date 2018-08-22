public class StudentsFactoryDao {
    static iStudents studentsDao;

    public static iStudents getStudentsDao() {
        if (studentsDao == null) {
            studentsDao = new StudentsDao();
        }
        return studentsDao;
    }
}
