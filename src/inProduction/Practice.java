package inProduction;

public class Practice {
  public static void main(String[] args) {
    printlnPractice06();
  }

  public static void calc() {
    int a = 10;
    int b = 2;
    int total = CalcLogic.tasu(a, b);
    int delta = CalcLogic.hiku(a, b);
    System.out.println("足したら" + total + "、引いたら" + delta);
  }

  public static void printlnPractice09_1() {
    int x = 2;
    int y = 3;
    printlnPractice09_2(x, y);

    int[] array = {1, 3, 7};
    printArray(array);
  }

  public static void printlnPractice09_2(int x, int y) {
    System.out.println(x + " + " + y + " = " + add(x, y));
    System.out.println(add(add(x, y), add(x, y)));
    System.out.println(add(2.3, 3.4));
  }

  public static int add(int x, int y) {
    int ans = x + y;
    return ans;
  }

  public static double add(double x, double y) {
    double ans = x + y;
    return ans;
  }

  public static void printArray(int[] array) {
    for (int value : array) {
      System.out.println(value);
    }
  }

  public static void printlnPractice08_1() {
    String name = "Junya";
    printlnPractice08_2(name);
  }

  public static void printlnPractice08_2(String name) {
    System.out.println(name);
  }

  public static void printlnPractice07() {
    int[] score = new int[5];
    int scoreLength = score.length;
    System.out.println(scoreLength);
    score[1] = 30;
    System.out.println(score[1]);
    System.out.println(score[2]);

    int[] score1 = new int[] {20, 30, 40, 50, 80};
    int[] score2 = {20, 30, 40, 50, 80};
    for (int i = 0; i < score1.length; i++) {
      System.out.println(score1[i]);
    }
    for (int value : score1) {
      System.out.println(value);
    }

    int[][] scores = new int[1][2];
    scores[0][0] = 40;
    scores[0][1] = 50;
    System.out.println(scores[0][1]);

    int[][] scores2 = { {10, 20, 30}, {40, 50}};
    System.out.println(scores2.length);
    System.out.println(scores2[0].length);


  }

  public static void printlnPractice06() {
    boolean tenki = true;
    if (tenki == true) {
      System.out.println("洗濯します");
    } else {
      System.out.println("掃除します");
    }

    boolean doorClose = true;
    while (doorClose == true) {
      System.out.println("ノックします");
      System.out.println("1分待ちます");
      doorClose = false;
    }
    System.out.println("入ります");

    int age = 19;
    String name = "小野";
    if (!(age >= 18) && name.equals("小野")) {
      System.out.println("You can drink");
    }
    int fortune = new java.util.Random().nextInt(3);
    switch (fortune) {
      case 1:
        System.out.println("Great");
        break;
      case 3:
        System.out.println("So so");
        break;
      default:
        System.out.println("Take it easy");
    }

    for (int i = 0; i < 5; i++) {
      if (i % 2 == 0) {
        continue;
      }
      System.out.println(i + " + + + + +");
    }

  }

  public static void printlnPractice05() {
    System.out.println("あなたの名前を入力してください");
    String name = new java.util.Scanner(System.in).nextLine();
    System.out.println("あなたの名前は" + name + "です");
  }

  public static void printlnPractice04() {
    int a;
    int b;
    a = 20;
    b = a + 5;
    System.out.println(a);
    System.out.println(b);
    a = b = 10;
    System.out.println(a);
    System.out.println("私の好きな記号は\"です。");
    a += 2;
    System.out.println(a);
    a -= 2;
    System.out.println(a);
    a /= 2;
    System.out.println(a);
    a %= 2;
    System.out.println(a);
    a++;
    System.out.println(a);
    a--;
    System.out.println(a);
    String string01 = "a";
    string01 += "aaaa";
    System.out.println(string01);
    a = 5;
    b = 2;
    System.out.println(a / b);
    double da = 5;
    double db = 2;
    System.out.println(da / b);

    int m = Math.max(a, b);
    System.out.println(m);

    String string10 = "10";
    int n = Integer.parseInt(string10);
    System.out.println(n);

    int r = new java.util.Random().nextInt(255);
    System.out.println(r);
  }

  public static void printlnPractice03() {
    final double TAX = 1.05;
    int fax = 5;
    fax = 4;
    System.out.println(fax * TAX + "万円");
  }

  public static void printlnPractice02() {
    boolean result = false;
    int age = 20;
    System.out.println(age + "歳です");
    age = 29;
    System.out.println("本当は" + age + "歳です");

  }

  public static void printlnPractice01() {
    System.out.println("すがわら");
    System.out.println("31 + 31の計算をします");
    System.out.println(31 + 31);
    System.out.println(35 - 10);
    System.out.println(-5 * 2);
    int x;
    x = 6;
    System.out.println(x * x * 3.14);
    System.out.println("答えは" + 60);

  }

}
