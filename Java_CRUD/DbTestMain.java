package dbStudy;

import java.util.Scanner;

public class DbTestMain {
    public static void main(String[] args) {

        DbTest dbTest = new DbTest();

        // dbSelect(Read)
        dbTest.dbSelect();

        // dbInsert(Create)

        // 값을 입력 받아 insert 실행
        Scanner sc = new Scanner(System.in);

        System.out.println("이름 입력 : ");
        String name = sc.next();
        System.out.println("그룹 입력 : ");
        String group = sc.next();
        System.out.println("나이 입력 : ");
        int old = sc.nextInt();
        System.out.println("장소 입력 : ");
        String place = sc.next();

        // Event class를 생성하여 입력
        Event event = new Event();
        event.setName(name);
        event.setGroupName(group);
        event.setOldYear(old);
        event.setPlace(place);

        dbTest.dbInsert(event);

        // dbUpdate
        dbTest.dbUpdate();

        // dbDelete
        dbTest.dbDelete();

    }
}
