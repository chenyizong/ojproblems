import java.util.*;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


public class online2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfCases = Integer.parseInt(sc.nextLine());
        while (numOfCases > 0) {
            int n = Integer.parseInt(sc.nextLine());
            Point[] points = new Point[n];
            String[] temp = sc.nextLine().split(" ");
            for (int i = 0; i < temp.length; i += 2) {
                int x = Integer.parseInt(temp[i]);
                int y = Integer.parseInt(temp[i + 1]);
                Point point = new Point(x, y);
                points[i / 2] = point;
            }
            convexHull(points, n);
            numOfCases -= 1;
        }
    }

    public static int orientation(Point p, Point q, Point r) {
        int val = (q.y - p.y) * (r.x - q.x) -
                (q.x - p.x) * (r.y - q.y);

        if (val == 0) return 0;
        return (val > 0) ? 1 : 2;
    }

    public static void convexHull(Point points[], int n) {
        if (n < 3) {
            System.out.println(-1);
            return;
        }

        Vector<Point> hull = new Vector<Point>();

        int l = 0;
        for (int i = 1; i < n; i++)
            if (points[i].x < points[l].x)
                l = i;

        int p = l, q;
        do {
            hull.add(points[p]);

            q = (p + 1) % n;

            for (int i = 0; i < n; i++) {
                if (orientation(points[p], points[i], points[q])
                        == 2)
                    q = i;
            }

            p = q;

        } while (p != l);
        Collections.sort(hull, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int x1 = o1.x;
                int y1 = o1.y;
                int x2 = o2.x;
                int y2 = o2.y;
                if (x1 != x2) {
                    return x1 - x2;
                } else {
                    return y1 - y2;
                }
            }
        });
        for (int i = 0; i < hull.size() - 1; i++) {
            Point temp = hull.get(i);
            System.out.print(temp.x + " " + temp.y + ", ");
        }
        Point last = hull.get(hull.size() - 1);
        System.out.print(last.x + " " + last.y);
        System.out.println();
    }


}