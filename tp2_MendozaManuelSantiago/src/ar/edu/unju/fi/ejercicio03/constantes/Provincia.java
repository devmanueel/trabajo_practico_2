package ar.edu.unju.fi.ejercicio03.constantes;

public enum Provincia {
	JUJUY(811611,53219), SALTA(1441351,155488), TUCUMAN(1731820,22524), 
	CATAMARCA(429562,102602), LA_RIOJA(383865,89680), SANTIAGO_DEL_ESTERO(1060906,136351);
	
	private int POBLACION;
	private int SUPERFICIE;
	
	
	private Provincia(int pOBLACION, int sUPERFICIE) {
		POBLACION = pOBLACION;
		SUPERFICIE = sUPERFICIE;
	}


	public int getPOBLACION() {
		return POBLACION;
	}
	public int getSUPERFICIE() {
		return SUPERFICIE;
	}
	//METODO PARA GENERAR LA DENSIDAD DE LA POBLACION
	public double calcularDensidadPoblacional() {
        return (double) POBLACION / SUPERFICIE;
    }
}