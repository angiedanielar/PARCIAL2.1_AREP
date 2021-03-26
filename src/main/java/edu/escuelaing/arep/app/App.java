package edu.escuelaing.arep.app;

import com.google.gson.Gson;
import edu.escuelaing.arep.app.model.Exp;
import edu.escuelaing.arep.app.services.Services;
import edu.escuelaing.arep.app.services.ServicesImpl;
import spark.Request;
import spark.Response;
import static spark.Spark.get;
import static spark.Spark.port;

/**
 * Spark web App that calculates the exponent
 * Es el número de eauler elevado a la potencia que indica del parámetro
 */
public class App {

    private static final Services services = new ServicesImpl();
    private static final Gson gson = new Gson();

    public static void main(String[] args) {
        port(getPort());
        get("/exp", App::expHandler);
    }

    /**
     * Does the exponent calculation
     *
     * @param request The HTTP request.
     * @param response The HTTP response.
     * @return The exponent of the number.
     */
    private static Object expHandler(Request request, Response response) {
        Double value = Double.parseDouble(request.queryParams("value"));
        Exp exp = services.getExponent(value);
        response.header("Content-Type", "application/json");
        return gson.toJson(exp);
    }

    /**
     * Get the port of the web app.
     *
     * @return The value of the port configured in the system environment, returns 4567 by default.
     */
    public static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}