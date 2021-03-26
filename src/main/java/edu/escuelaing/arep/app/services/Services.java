package edu.escuelaing.arep.app.services;

import edu.escuelaing.arep.app.model.Exp;

/**
 * Interface that generate the services of the App.
 */
public interface Services {

	/**
     * Does the exponent calculation
     *
     * @param number The number to be calculate.
     * @return The Exp Object with the response.
     */
	Exp getExponent(Double number);

}
