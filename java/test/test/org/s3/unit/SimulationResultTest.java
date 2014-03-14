package test.org.s3.unit;

import org.junit.Test;
import org.s3.SimulationResult;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class SimulationResultTest {

    private double [][][] multipleSamples = new double [3][1][3];
    {
        multipleSamples[0][0] = new double[]{4,5,6};
        multipleSamples[1][0] = new double[]{1,2,3};
        multipleSamples[2][0] = new double[]{5,5,5};
    }

    private double [][][] singleSample = new double [3][1][1];
    {
        singleSample[0][0] = new double[]{1};
        singleSample[1][0] = new double[]{2};
        singleSample[2][0] = new double[]{3};
    }

    @Test
    public void testMean() throws Exception {
        double sampleMean = new SimulationResult(multipleSamples).mean();
        assertEquals("sample mean multiple", 4.0, sampleMean);

        sampleMean = new SimulationResult(singleSample).mean();
        assertEquals("sample mean single", 2.0, sampleMean);
    }

    @Test
    public void testLast() throws Exception {
        double [] lastSample = new SimulationResult(multipleSamples).last();
        assertArrayEquals("last sample multiple", multipleSamples[2][0], lastSample, 0.0);

        lastSample = new SimulationResult(singleSample).last();
        assertArrayEquals("last sample single", singleSample[2][0], lastSample, 0.0);
    }

    @Test
    public void testMin() throws Exception {
        double [] min = new SimulationResult(multipleSamples).min();
        assertArrayEquals("min multiple", multipleSamples[1][0], min, 0.0);

        min = new SimulationResult(singleSample).min();
        assertArrayEquals("min single", singleSample[0][0], min, 0.0);
    }

    @Test
    public void testMax() throws Exception {
        double [] max = new SimulationResult(multipleSamples).max();
        assertArrayEquals("max multiple", multipleSamples[0][0], max, 0.0);

        max = new SimulationResult(singleSample).max();
        assertArrayEquals("max single", singleSample[2][0], max, 0.0);
    }

    @Test
    public void testRange() throws Exception {
        double [][] range = new SimulationResult(multipleSamples).range();
        assertArrayEquals("range min multiple", multipleSamples[1][0], range[0], 0.0);
        assertArrayEquals("range max multiple", multipleSamples[0][0], range[1], 0.0);

        range = new SimulationResult(singleSample).range();
        assertArrayEquals("range min single", singleSample[0][0], range[0], 0.0);
        assertArrayEquals("range max single", singleSample[2][0], range[1], 0.0);
    }
}
