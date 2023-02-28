package dbStudy;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;

import static jdk.nashorn.internal.objects.NativeDate.now;

public class DbTest {
    public void dbSelect(){
        /*
        1. ip(domain)
        2. port
        3. 계정
        4. 패스워드
        5. 인스턴스
        jdbc:DB_VENDER://IP_ADDR:IP_PORT/INSTANCE
        */

        String url = "jdbc:mariadb://localhost:3306/testdb1";
        String dbUserId = "testuser1";
        String dbPassword = "0000";


        //1. 드라이버 로드
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //2. 커넥션 개채 생성
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        String groupNameValue = "kakao";

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            //3. 스테이트먼트 객체 생성
            String sql = " SELECT name, group_name, old_year, register_date , place " +
                    " FROM event " +
                    " WHERE group_name = ? ";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, groupNameValue); // 파라미터 인덱스로 값 넣기

            //4. 쿼리실행
            rs = preparedStatement.executeQuery();

            //5. 결과 수행
            while (rs.next()) {

                String name = rs.getString("name");
                String group_name = rs.getString("group_name");
                int old_year = rs.getInt("old_year");
                Date register_date = rs.getDate("register_date");
                String place = rs.getString("place");

                System.out.println(name + ", "+ group_name + ", " + old_year + ", " + register_date + ", " + place);
            }




        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //6. 객체 연결 해제(close) - 무조건 실행 되어야하므로 마지막에 실행
            try {
                if (rs != null && !rs.isClosed()){
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()){
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null && !connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void dbInsert(Event event){

        String url = "jdbc:mariadb://localhost:3306/testdb1";
        String dbUserId = "testuser1";
        String dbPassword = "0000";


        //1. 드라이버 로드
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //2. 커넥션 개채 생성
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            //3. 스테이트먼트 객체 생성
            String sql = " INSERT into event (name, group_name, old_year, register_date, place) " +
                    " values (?, ?, ?, now(), ?); ";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, event.getName()); // 파라미터 인덱스로 값 넣기
            preparedStatement.setString(2, event.getGroupName()); // 파라미터 인덱스로 값 넣기
            preparedStatement.setInt(3, event.getOldYear()); // 파라미터 인덱스로 값 넣기
            preparedStatement.setString(4, event.getPlace()); // 파라미터 인덱스로 값 넣기

            //4. 쿼리실행
            int effected = preparedStatement.executeUpdate();

            // 5. 결과 확인
            if (effected > 0){
                System.out.println("저장 성공");
            } else {
                System.out.println("저장 실패");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            //6. 객체 연결 해제(close) - 무조건 실행 되어야하므로 마지막에 실행
            try {
                if (rs != null && !rs.isClosed()){
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()){
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null && !connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void dbUpdate (){

        String url = "jdbc:mariadb://localhost:3306/testdb1";
        String dbUserId = "testuser1";
        String dbPassword = "0000";


        //1. 드라이버 로드
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //2. 커넥션 개채 생성
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        String placeValue = "daejeon";
        String oldPlaceValue = "deagu";

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            //3. 스테이트먼트 객체 생성
            String sql = " UPDATE event " +
                    " set place = ? " +
                    " where place = ? ";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, placeValue); // 파라미터 인덱스로 값 넣기
            preparedStatement.setString(2, oldPlaceValue); // 파라미터 인덱스로 값 넣기

            //4. 쿼리실행
            int effected = preparedStatement.executeUpdate();

            // 5. 결과 확인
            if (effected > 0){
                System.out.println("업데이트 성공");
            } else {
                System.out.println("업데이트 실패");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            //6. 객체 연결 해제(close) - 무조건 실행 되어야하므로 마지막에 실행
            try {
                if (rs != null && !rs.isClosed()){
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()){
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null && !connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void dbDelete (){

        String url = "jdbc:mariadb://localhost:3306/testdb1";
        String dbUserId = "testuser1";
        String dbPassword = "0000";


        //1. 드라이버 로드
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //2. 커넥션 개채 생성
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        int oldValue = 38;

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            //3. 스테이트먼트 객체 생성
            String sql = " DELETE FROM event " +
                    " WHERE old_year = ?; ";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, oldValue); // 파라미터 인덱스로 값 넣기

            //4. 쿼리실행
            int effected = preparedStatement.executeUpdate();

            // 5. 결과 확인
            if (effected > 0){
                System.out.println("삭제 성공");
            } else {
                System.out.println("삭제 실패");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            //6. 객체 연결 해제(close) - 무조건 실행 되어야하므로 마지막에 실행
            try {
                if (rs != null && !rs.isClosed()){
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()){
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null && !connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



}
