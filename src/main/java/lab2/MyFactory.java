package lab2;

import org.uncommons.watchmaker.framework.factories.AbstractCandidateFactory;

import java.util.Random;

public class MyFactory extends AbstractCandidateFactory<double[]>
{
    private int dimension;

    public MyFactory(int dimension)
    {
        this.dimension = dimension;
    }

    public double[] generateRandomCandidate(Random random)
    {
        double[] candidate = new double[dimension];
        // x from -5.0 to 5.0

        // your implementation:
        for (int i = 0; i < dimension; i++) {
            candidate[i] = random.nextDouble() * 10.0 - 5.0;
        }

        return candidate;
    }
}