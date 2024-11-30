package code.data;

import code.models.Grade;
import code.utils.ConnectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GradeDAO {
    private Connection connection;

    public GradeDAO() {

        this.connection = ConnectDB.getConnection();
    }

    public List<Grade> getAllGrades() {
        List<Grade> grades = new ArrayList<>();
        String query = "SELECT * FROM grades";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int studentId = resultSet.getInt("student_id");
                String subject = resultSet.getString("subject");
                double score = resultSet.getDouble("score");
                Grade grade = new Grade(id, studentId, subject, score);
                grades.add(grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grades;
    }

    public void addGrade(Grade grade) {
        String query = "INSERT INTO grades (student_id, subject, score) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, grade.getStudentId());
            preparedStatement.setString(2, grade.getSubject());
            preparedStatement.setDouble(3, grade.getScore());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateGrade(Grade grade) {
        String query = "UPDATE grades SET student_id=?, subject=?, score=? WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, grade.getStudentId());
            preparedStatement.setString(2, grade.getSubject());
            preparedStatement.setDouble(3, grade.getScore());
            preparedStatement.setInt(4, grade.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteGrade(int gradeId) {
        String query = "DELETE FROM grades WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, gradeId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteAllGrades() {
        try (
             PreparedStatement statement = connection.prepareStatement("DELETE FROM grades")) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
