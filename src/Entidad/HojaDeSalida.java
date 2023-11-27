package Entidad;





/**
 * @author Pablo
 * @version 1.0
 * @created 28-may-2016 11:55:01
 */
public class HojaDeSalida {

	private int id;
	private float costo;
	private String hora;
        private int codPlanilla;
      
	public HojaDeSalida(){
  
	}

    public HojaDeSalida(int id, float costo, String hora, int codPlanilla) {
        this.id = id;
        this.costo = costo;
        this.hora = hora;
        this.codPlanilla = codPlanilla;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getCodPlanilla() {
        return codPlanilla;
    }

    public void setCodPlanilla(int codPlanilla) {
        this.codPlanilla = codPlanilla;
    }

   
}