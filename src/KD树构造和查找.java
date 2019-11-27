import java.util.*;
import java.util.stream.Collectors;

public class KD树构造和查找 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        for (int t = 0; t < times; t++) {
            scanner.nextLine();
            String str = scanner.nextLine();
            List<KdNode> KdNodes = new ArrayList<>();
            for (String s : str.split(",")) {
                String[] ss = s.split(" ");
                KdNodes.add(new KdNode(Double.parseDouble(ss[0]), Double.parseDouble(ss[1])));
            }
            double x = variance(KdNodes.stream().map(KdNode -> KdNode.x).collect(Collectors.toList()));
            double y = variance(KdNodes.stream().map(KdNode -> KdNode.y).collect(Collectors.toList()));
            KdNode kdNode = construct(KdNodes, x > y ? 0 : 1);
            KdNode target = new KdNode(scanner.nextDouble(), scanner.nextDouble());
            int k = scanner.nextInt();
            Map<Double, KdNode> distance = new HashMap<>();
            List<Double> minK = distance(kdNode, target, distance, k);
            StringBuilder stringBuilder = new StringBuilder();
            for (Double d : minK) {
                KdNode temp = distance.get(d);
                x = temp.x;
                y = temp.y;
                stringBuilder.append(",");
                if ((int) x == x) {
                    stringBuilder.append(temp.x.intValue());
                } else {
                    stringBuilder.append(x);
                }
                stringBuilder.append(" ");
                if ((int) y == y) {
                    stringBuilder.append(temp.y.intValue());
                } else {
                    stringBuilder.append(y);
                }
            }
            System.out.println(stringBuilder.deleteCharAt(0));

        }
    }

    private static double variance(List<Double> x) {
        int m=x.size();
        double sum=0;
        for (double aX : x) {//求和
            sum += aX;
        }
        double dAve=sum/m;//求平均值
        double dVar=0;
        for (double aX : x) {//求方差
            dVar += (aX - dAve) * (aX - dAve);
        }
        return dVar/m;
    }

    private static List<Double> distance(KdNode kdNode, KdNode target, Map<Double, KdNode> distance, int k) {
        List<Double> minK = new ArrayList<>();

        Stack<KdNode> stack = new Stack<>();
        stack.push(kdNode);
        while (!stack.empty()) {
            KdNode temp = stack.pop();
            if (temp == null) {
                continue;
            }
            double d = distance(temp, target, minK, distance, k);
            if (temp.dimension == 0) {
                stack.push(temp.x < target.x ? temp.right : temp.left);
            } else {
                stack.push(temp.y < target.y ? temp.right : temp.left);
            }
            if (temp.father != null) {
                if (temp.father.dimension == 0) {
                    if (temp.father.x < target.x && target.x - minK.get(minK.size() - 1) < temp.father.x && temp.father.left != temp) {
                        stack.push(temp.father.left);
                    } else if (temp.father.x > target.x && target.x + minK.get(minK.size() - 1) > temp.father.x && temp.father.right != temp) {
                        stack.push(temp.father.right);
                    }
                } else {
                    if (temp.father.y < target.y && target.y - minK.get(minK.size() - 1) < temp.father.y && temp.father.left != temp) {
                        stack.push(temp.father.left);
                    } else if (temp.father.y > target.y && target.y + minK.get(minK.size() - 1) > temp.father.y && temp.father.right != temp) {
                        stack.push(temp.father.right);
                    }
                }
            }
        }
        return minK;
    }

    private static double distance(KdNode kdNode, KdNode target, List<Double> minK, Map<Double, KdNode> distance, int k) {
        double d = kdNode.distance(target);
        if (minK.size() < k) {
            minK.add(d);
            distance.put(d, kdNode);
            minK.sort(Double::compareTo);
        } else {
            if (minK.get(k - 1) > d) {
                minK.remove(k-1);
                distance.remove(d);
                minK.add(d);
                distance.put(d, kdNode);
                minK.sort(Double::compareTo);
            }
        }
        return d;
    }

    private static KdNode construct(List<KdNode> KdNodes, int dimension) {
        if (KdNodes.size() == 0) {
            return null;
        }
        List<KdNode> left = new ArrayList<>();
        List<KdNode> right = new ArrayList<>();
        if (dimension == 0) {
            KdNodes.sort(Comparator.comparingDouble(o -> o.x));
        } else {
            KdNodes.sort(Comparator.comparingDouble(o -> o.y));
        }
        int mid = KdNodes.size() / 2;
        KdNode kdNode = KdNodes.get(mid);
        for (int i = 0; i < mid; i++) {
            left.add(KdNodes.get(i));
        }
        for (int i = mid + 1; i < KdNodes.size(); i++) {
            right.add(KdNodes.get(i));
        }
        kdNode.left = construct(left, dimension ^ 1);
        kdNode.right = construct(right, dimension ^ 1);
        if (kdNode.left != null) {
            kdNode.left.father = kdNode;
        }
        if (kdNode.right != null) {
            kdNode.right.father = kdNode;
        }
        kdNode.dimension = dimension;
        return kdNode;
    }
}
class KdNode {
    Double x;
    Double y;
    int dimension;
    KdNode left;
    KdNode right;
    KdNode father;

    KdNode(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double distance(KdNode target) {
        return Math.sqrt(Math.pow(x - target.x, 2) + Math.pow(y - target.y, 2));
    }
}