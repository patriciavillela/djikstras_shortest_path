import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    List<Node> nodes = new ArrayList<>();
    List<Vertex> vertices;
    Node start,end;
    class Node implements Comparable {
        Node(char name) { this.name = name; weight = Integer.MAX_VALUE; }
        char name;
        int weight;
        Node path;
        @Override
        public int compareTo(Object o) {
            return o instanceof Node ? this.weight-((Node)o).weight : 0;
        }
        @Override
        public String toString() {
            return name+"-"+weight+"-"+path;
        }
    }
    class Vertex {
        Vertex(Node start,Node end,int weight) { this.start = start;this.weight = weight;this.end = end;}
        Node start;
        int weight;
        Node end;
        @Override
        public String toString() {
            return start.name+"--"+weight+"-->"+end.name;
        }
    }
    public void setup() {
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Vertex AB = new Vertex(A,B,3);
        Vertex AC = new Vertex(A,C,4);
        Vertex AE = new Vertex(A,E,89);
        Vertex BC = new Vertex(B,C,2);
        Vertex CD = new Vertex(C,D,7);
        Vertex DE = new Vertex(D,E,3);
        Vertex EF = new Vertex(E,F,3);
        Vertex EG = new Vertex(E,G,6);
        Vertex FG = new Vertex(F,G,5);
        nodes.addAll(Arrays.asList(A,B,C,D,E,F,G));
        Collections.sort(nodes);
        vertices = Arrays.asList(AB,AC,AE,BC,CD,DE,EF,EG,FG);
        start=A;
        end=G;
    }
    public void setup2() {
        Node S = new Node('S');
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');
        Node I = new Node('I');
        Node J = new Node('J');
        Node K = new Node('K');
        Node L = new Node('L');
        Node E = new Node('E');
        Vertex SA = new Vertex(S,A,7);
        Vertex SB = new Vertex(S,B,2);
        Vertex SC = new Vertex(S,C,3);
        Vertex AB = new Vertex(A,B,3);
        Vertex AD = new Vertex(A,D,4);
        Vertex BD = new Vertex(B,D,4);
        Vertex HF = new Vertex(H,F,3);
        Vertex DF = new Vertex(D,F,5);
        Vertex BH = new Vertex(B,H,1);
        Vertex HG = new Vertex(H,G,2);
        Vertex GE = new Vertex(G,E,2);
        Vertex CL = new Vertex(C,L,2);
        Vertex LI = new Vertex(L,I,4);
        Vertex LJ = new Vertex(L,J,4);
        Vertex IJ = new Vertex(I,J,6);
        Vertex JK = new Vertex(J,K,4);
        Vertex IK = new Vertex(I,K,4);
        Vertex KE = new Vertex(K,E,5);
        nodes.addAll(Arrays.asList(S,A,B,C,D,F,G,H,I,J,K,L,E));
        Collections.sort(nodes);
        vertices = Arrays.asList(SA,SB,SC,AB,AD,BD,HF,DF,BH,HG,GE,CL,LI,LJ,IJ,JK,IK,KE);
        start=S;
        end=E;
    }
    public void run() {
        setup2();
        start.weight = 0;
        List<Node> visitados = new ArrayList<>();
        while(nodes.size() > 0) {
            Node n = nodes.get(0);
            System.out.println(n.name + " - " + n.weight);
            for (Vertex v : vertices) {
                if(v.start == n && v.end.weight > v.start.weight + v.weight) {
                    v.end.weight = v.start.weight + v.weight;
                    v.end.path = n;
                }
            }
            visitados.add(n);
            nodes.remove(n);
            Collections.sort(nodes);
        }
        System.out.println(end);
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
