package cn.bulletjet;

/**
 * queen solution
 *
 * @author Bullet
 * @time 2017-09-19 2:02
 */
public class QueenSolution {

  private int[] queenAddress;
  private int sum = 0;
  private boolean willPrint = false;

  public boolean isWillPrint() {
    return willPrint;
  }

  public void setWillPrint(boolean willPrint) {
    this.willPrint = willPrint;
  }

  /**
   * 对i皇后，是否存在i皇后和j(0<=j<=i-1)皇后冲突：
   * 1.   斜线存在(a[i] - a[j]) / (j - i) == 1
   * 2. 同行冲突：即存在a[j]含有两个值，显然不成立
   * 3.   同列冲突：即存在a[i] = a[i]
   *
   * @param i 要检测的皇后所在下标
   * @return true表示存在冲突，false表示不存在冲突
   */
  private boolean exitsConflictForINode(int i) {
    for (int j = 0; j < i; j++) {
      if (queenAddress[j] == queenAddress[i]
          || queenAddress[j] - queenAddress[i] == j - i
          || queenAddress[j] - queenAddress[i] == i - j) {
        return true;
      }
    }
    return false;
  }

  /**
   * 取得指定数量的皇后问题的解个数
   *
   * @param num_queen 指定的皇后个数
   * @return 解的个数
   */
  public int getNumOfSolutionOfQueenQuestion(int num_queen) {
    queenAddress = new int[num_queen];
    // 从第0层开始填充不同的值
    tryFromI(0);
    return sum;
  }

  private void tryFromI(int i) {
    // 基准条件，尝试完毕
    if (i == queenAddress.length) {
      sum++;
      if (willPrint == true) {
        printSolution();
      }
      return ;
    }

    // 递归情形
    for (int k = 0; k < queenAddress.length; k++) {
      queenAddress[i] = k;
      if (!exitsConflictForINode(i)) {
        tryFromI(i + 1);
      }
    }
  }

  private void printSolution() {
    for (int i = 0; i < queenAddress.length; i++) {
      for (int j = 0; j < queenAddress[i]; j++) {
        System.out.print((char) 254);
      }
      System.out.print((char) 255);
      for (int j = queenAddress[i] + 1; j < queenAddress.length; j++) {
        System.out.print((char) 254);
      }
      System.out.println();
    }
    System.out.println();

  }
}