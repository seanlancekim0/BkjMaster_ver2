import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        //입력값 저장하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<>();	//글자 저장할 Stack
        String input = br.readLine();	//문자열
        String word = br.readLine();	//폭발 문자열
        //문자열이 폭발 문자열보다 길이가 작으면 폭발할 일이 없습니다.
        if (word.length() > input.length()) {
            bw.write(input);
        } else {
            //문자열 탐색
            for (int i = 0; i < input.length(); i++) {
                stack.add(input.charAt(i));
                //글자가 폭발 문자열에 마지막 글자인지 확인
                if (stack.size() >= word.length() && stack.peek() == word.charAt(word.length()-1)) {
                    boolean check = false;
                    //폭발 문자열인지 확인
                    for (int j = 0; j < word.length(); j++) {
                        if (stack.get(stack.size() - word.length() + j) != word.charAt(j)) {
                            check = true;
                            break;
                        }
                    }
                    //폭발 문자열일 때 Stack에 저장된 정보 폭발시키기
                    if (!check) {
                        for (int j = 0; j < word.length(); j++)
                            stack.pop();
                    }
                }
            }
            //Stack에 저장된 정보 저장
            StringBuilder answer = new StringBuilder();
            for(Character c : stack)
                answer.append(c);

            //문자열이 폭발된 후에도 남아있을 경우
            if(answer.length()>0)
                bw.write(answer.toString());
            else		//문자열이 모두 폭발 되었을 때
                bw.write("FRULA");
        }
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
}
/*
12ab112
12ab
 */