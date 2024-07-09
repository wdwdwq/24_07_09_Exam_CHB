package org.example;

import org.example.entity.Motivation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private static int lastId = 0; // 클래스 변수로 선언
    private static List<Motivation> ms = new ArrayList<>(); // 클래스 변수로 선언

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("==명언 앱 실행==");



        while (true) {
            System.out.print("명령어 ) ");
            String cmd = sc.nextLine().trim();

            if (cmd.length() == 0) {
                System.out.println("명령어 하세요");
                continue;
            }
            if (cmd.equals("나가기")) {
                System.out.println("==나가기==");
                break;
            }

            if (cmd.equals("등록")) {
                int id = lastId + 1;
                String regDate = Util.getNow();
                System.out.print("명언 : ");
                String content = sc.nextLine();
                System.out.print("작가 : ");
                String author = sc.nextLine();

                Motivation m = new Motivation(id, regDate, content, author);
                ms.add(m);

                System.out.println(id + "번 명언이 등록 되었습니다");
                lastId++;
            } else if (cmd.equals("목록")) {
                if (ms.size() == 0) {
                    System.out.println("등록된 명언 없음");
                    continue;
                }
                    System.out.println("  번호   /    작가   /   명언");
                    System.out.println("=".repeat(35));

                for (int i = ms.size() - 1; i >= 0; i--) {
                    Motivation m = ms.get(i);
                    System.out.printf("   %d  /    %s     /    %s  \n", m.getId(), m.getContent(), m.getAuthor());
                }
            } else if (cmd.startsWith("상세보기")) {
                int id = Integer.parseInt(cmd.split(" ")[1]);

                Motivation fm = null;

                for (Motivation m : ms) {
                    if (m.getId() == id) {
                        fm = m;
                        break;
                    }
                }

                if (fm == null) {
                    System.out.printf(id + "번 명언은 존재하지 않습니다");
                    continue;
                }

                System.out.printf("번호 : %d\n", fm.getId());
                System.out.println("날짜 : " + fm.getRegDate());
                System.out.printf("작가 : %s\n", fm.getAuthor());
                System.out.printf("내용 : %s\n", fm.getContent());


            } else if (cmd.startsWith("수정")) {

                int id = Integer.parseInt(cmd.split(" ")[1]);

                Motivation fm = null;
                for (Motivation m : ms) {
                    if (m.getId() == id) {
                        fm = m;
                        break;
                    }
                }

                if (fm == null) {
                    System.out.printf(id + "번 명언은 존재하지 않습니다");
                    continue;
                }

                System.out.println("명언(기존) : " + fm.getContent());
                System.out.println("명언(작가) : " + fm.getAuthor());
                System.out.print("명언 : ");
                String nc = sc.nextLine();
                System.out.print("작가 : ");
                String na = sc.nextLine();

                fm.setContent(nc);
                fm.setAuthor(na);

                System.out.printf(id + "번 명언이 수정되었습니다");

            } else if (cmd.startsWith("삭제")) {
                int id = Integer.parseInt(cmd.split(" ")[1]);

                Motivation fm = null;

                for (Motivation m : ms) {
                    if (m.getId() == id) {
                        fm = m;
                        break;
                    }
                }

                if (fm == null) {
                    System.out.printf(id + "번 명연은 존재하지 않습니다");
                    continue;
                }

                ms.remove(fm);
                System.out.printf(id + "번 명언이 삭제되었습니다");

            } else {
                System.out.println("명령어 존재하지 않습니다");
            }
        }




        sc.close();
    }
}