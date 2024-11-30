package code.data;

import code.models.Attendance;
import code.utils.ConnectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDAO {
    private Connection connection;

    public AttendanceDAO() {

        this.connection = ConnectDB.getConnection();

    }

    public List<Attendance> getAllAttendances() {
        List<Attendance> attendances = new ArrayList<>();
        String query = "SELECT * FROM attendances";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int studentId = resultSet.getInt("student_id");
                String date = resultSet.getString("date");
                boolean present = resultSet.getBoolean("present");
                Attendance attendance = new Attendance(id, studentId, date, present);
                attendances.add(attendance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendances;
    }

    public void addAttendance(Attendance attendance) {
        String query = "INSERT INTO attendances (student_id, date, present) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, attendance.getStudentId());
            preparedStatement.setString(2, attendance.getDate());
            preparedStatement.setBoolean(3, attendance.isPresent());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAttendance(Attendance attendance) {
        String query = "UPDATE attendances SET student_id=?, date=?, present=? WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, attendance.getStudentId());
            preparedStatement.setString(2, attendance.getDate());
            preparedStatement.setBoolean(3, attendance.isPresent());
            preparedStatement.setInt(4, attendance.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAttendance(int attendanceId) {
        String query = "DELETE FROM attendances WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, attendanceId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void deleteAllAttendances() {
        try (
             PreparedStatement statement = connection.prepareStatement("DELETE FROM attendances")) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
