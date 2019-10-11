package lab2;

import org.uncommons.watchmaker.framework.operators.AbstractCrossover;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyCrossover extends AbstractCrossover<double[]>
{
    protected MyCrossover()
    {
        super(1);
    }

    protected List<double[]> mate(double[] p1, double[] p2, int numberOfCrossoverPoints, Random random)
    {
        if (p1.length != p2.length || numberOfCrossoverPoints > p1.length) {
            System.out.println("Invalid parent length or numberOfCrossoverPoints");
            System.exit(1);
        }

        ArrayList children = new ArrayList(2);

        // your implementation:
        boolean[] crossoverPoints = this.generateCrossoverPoints(p1.length, numberOfCrossoverPoints, random);
        double[] child1 = new double[p1.length];
        double[] child2 = new double[p1.length];
        for (int i = 0; i < p1.length; i++) {
            child1[i] = crossoverPoints[i] ? p2[i] : p1[i];
            child2[i] = crossoverPoints[i] ? p1[i] : p2[i];
        }

        children.add(child1);
        children.add(child2);

        // children.add(p1);
        // children.add(p2);
        return children;
    }

    private boolean[] generateCrossoverPoints(int length, int n, Random random)
    {
        // Fill a list with the required number of crossovers
        boolean[] crossoverPoints = new boolean[length];
        for (int i = 0; i < crossoverPoints.length; i++)
            crossoverPoints[i] = (i < n);

        // Shuffle the list
        for (int i = crossoverPoints.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);

            boolean swp = crossoverPoints[index];
            crossoverPoints[index] = crossoverPoints[i];
            crossoverPoints[i] = swp;
        }

        return crossoverPoints;
    }
}
