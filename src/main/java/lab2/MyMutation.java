package lab2;

import org.uncommons.watchmaker.framework.EvolutionaryOperator;

import java.util.List;
import java.util.Random;

public class MyMutation implements EvolutionaryOperator<double[]>
{
    public List<double[]> apply(List<double[]> population, Random random)
    {
        // initial population
        // need to change individuals, but not their number!

        // your implementation:
        for (int i = 0; i < population.size(); i++) {
            double[] individual = population.get(i);
            double mutationChance = 1.0 / (double)individual.length;

            for (int j = 0; j < individual.length; j++) {
                if (random.nextDouble() <= mutationChance)
                    individual[j] = random.nextDouble() * 10.0 - 5.0;
            }
        }

        // result population
        return population;
    }
}
