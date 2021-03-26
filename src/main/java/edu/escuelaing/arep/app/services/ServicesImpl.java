package edu.escuelaing.arep.app.services;

import edu.escuelaing.arep.app.model.Exp;

/**
 * Class that implements the services of the Services.
 */
public class ServicesImpl implements Services {

    /**
     * Does the exponent calculation
     *
     * @param number The number to be calculate.
     * @return The Exp Object with the response.
     */
    @Override
    public Exp getExponent(Double number) {
        Double exp = Math.pow(Math.E,number);
        return new Exp("exp", number, exp);
    }

}