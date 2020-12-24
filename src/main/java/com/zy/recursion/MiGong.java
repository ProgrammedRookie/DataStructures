package com.zy.recursion;

/**
 * @author zy
 */
public class MiGong {

    public static void main(String[] args) {
        int[][] map = new int[8][7];

        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        for (int i = 0; i < 7; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        map[3][1] = 1;
        map[3][2] = 1;


        setWay(map, 1, 1);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.printf(map[i][j] + "  ");
            }
            System.out.println();
        }


    }

    /**
     * 寻找规则 下 -> 右 -> 上  -> 左
     * 0：没有寻找过的位置
     * 1：墙
     * 3：走过不通的点
     * 2：已走过的点
     *
     * @param map 地图
     * @param   i, j, 起始位置
     * @param
     * @return
     */
    public static boolean setWay(int[][] map, int i, int j) {

        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                // 先设置点为走过的路，不通在进行修改
                map[i][j] = 2;
                // 根据规则 下右上左进行寻找
                if (setWay(map, i - 1, j)) {
                    // 下
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    // 右
                    return true;
                } else if (setWay(map, i + 1, j)) {
                    // 上
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    // 左
                    return true;
                } else {
                    // 此处不通
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
