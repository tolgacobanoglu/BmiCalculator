package com.tolgacobanoglu.bmicalculator;

public class BMI
{
    private final double weight;
    private final double height;

    public BMI(double weight, double height)
    {
        this.weight = weight;
        this.height = height;
    }

    public double calculate()
    {
        double result;
        result = weight / (height*0.01*height*0.01); //convert cm to m
        return result; // kg/m^2
    }

    public String state()
    {
        String state;
        double result = calculate();

        if (result < 18.5)
        {
            return "Underweight";
        }
        else if (result >= 18.5 && result <= 24.9)
        {
            return "Normal Weight";
        }
        else if (result >= 25 && result <=29.9)
        {
            return "Overweight";
        }
        else if (result >= 30)
        {
            return "Overweight";
        }

        return "Incalculable";
    }

}
