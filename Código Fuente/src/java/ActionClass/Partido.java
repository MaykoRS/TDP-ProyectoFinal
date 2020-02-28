package ActionClass;

import Bean.Jugador;
import com.opensymphony.xwork2.ActionSupport;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.struts2.ServletActionContext;

/**
 * @author Mayko Rodríguez - LU: 109130, alumno de la Universidad Nacional del Sur
 */
public class Partido extends ActionSupport{

    private int cantJugadores;
    private int maxCantidadJugadores;
    private ArrayList<Jugador> jugadores;
    private String legajoF;
    private String nombreF;
    private String apellidoF;
    
    private String estadoF;
    private String deporte;
    
    
    public String inscribirJugador(){
        try {
            this.setEstadoF("exitosa");
            File f = this.obtenerArchivo();
                
            FileWriter fw;
            fw = new FileWriter(f, true);
            BufferedWriter bw;
            bw = new BufferedWriter(fw);
            
            if (f.exists() && f.length() != 0) {
                bw.newLine();
            }
            bw.write(legajoF + " " + nombreF + " " + apellidoF);
            
            bw.close();
            fw.close();
            
            addActionMessage("Felicidades, se inscribió exitosamente !!");
            
        } catch (IOException e) {
        }
        return SUCCESS;
    }
    
    public String borrarJugador(){
        String ir = ERROR;

        try {
            /* La idea general de este método es borrar todo el contenido del archivo, sin antes guardar a todos los jugadores 
               en un arreglo de String. Luego escribir nuevamente a los jugadores en el archivo a excepción del jugador que 
               tiene como legajo el mismo valor del legajo "leg" pasado por parámetro.
            */
            File f = this.obtenerArchivo();
            if(f.exists()) {
                FileReader fr;
                fr = new FileReader(f);
                BufferedReader br;
                br = new BufferedReader(fr);
                String linea;
                
                /* En este arreglo guardo a todos los jugadores del archivo */
                String gamersArray [] = new String[this.cantidadLineas()];
                int i = 0;
                
                /* Coloco a todos los jugadores en el arreglo (legajo nombre apellido) */
                while((linea=br.readLine()) != null){
                    gamersArray[i] = linea;
                    i++;
                }
                br.close();
                fr.close();
                
                FileWriter fw;
                fw = new FileWriter(f);
                BufferedWriter bw;
                bw = new BufferedWriter(fw);
                boolean encontre = false;
                boolean esPrimeraLinea = true;
                for (String str : gamersArray) {
                    String[] arrayAux = str.split(" ");
                    if (arrayAux[0].equals(this.legajoF)) {
                        encontre = true;
                        addActionMessage("El jugador ha sido borrado de la lista satisfactoriamente");
                        ir = SUCCESS;
                    } else {
                        if(esPrimeraLinea){
                            esPrimeraLinea = false;
                        }else{
                            bw.newLine();
                        }
                        bw.write(str);
                    }
                }
                if(!encontre) {
                    addActionError("La lista se encuentra vacía");
                }
                bw.close();
                fw.close();
                
            }else{
                addActionError("No hay nada que borrar");
            }
            
            
        } catch (IOException e) {
            addActionError("IOException");
        }
        this.estadoF = ir;
        return ir;
    }
    
    /**
     * @return the cantJugadores
     */
    public int getCantJugadores() {
        return cantJugadores;
    }

    /**
     * @param cantJugadores the cantJugadores to set
     */
    public void setCantJugadores(int cantJugadores) {
        this.cantJugadores = cantJugadores;
    }

    /**
     * @return the jugadores
     */
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    /**
     * @param jugadores the jugadores to set
     */
    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    /**
     * @return the legajoF
     */
    public String getLegajoF() {
        return legajoF;
    }

    /**
     * @param legajoF the legajoF to set
     */
    public void setLegajoF(String legajoF) {
        this.legajoF = legajoF;
    }

    /**
     * @return the nombreF
     */
    public String getNombreF() {
        return nombreF;
    }

    /**
     * @param nombreF the nombreF to set
     */
    public void setNombreF(String nombreF) {
        this.nombreF = nombreF;
    }

    /**
     * @return the apellidoF
     */
    public String getApellidoF() {
        return apellidoF;
    }

    /**
     * @param apellidoF the apellidoF to set
     */
    public void setApellidoF(String apellidoF) {
        this.apellidoF = apellidoF;
    }
    
    /**
     * @return the estadoF
     */
    public String getEstadoF() {
        return estadoF;
    }

    /**
     * @param estadoF the estadoF to set
     */
    public void setEstadoF(String estadoF) {
        this.estadoF = estadoF;
    }
    
    /**
     * @return the deporte
     */
    public String getDeporte() {
        return deporte;
    }

    /**
     * @param deporte the deporte to set
     */
    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }
    
    /**
     * @return the maxCantidadJugadores
     */
    public int getMaxCantidadJugadores() {
        return maxCantidadJugadores;
    }

    /**
     * @param maxCantidadJugadores the maxCantidadJugadores to set
     */
    public void setMaxCantidadJugadores(int maxCantidadJugadores) {
        this.maxCantidadJugadores = maxCantidadJugadores;
    }
    
    /* Contabilizo la cantidad de jugadores inscriptos en deporte futbol */
    @SuppressWarnings("ConvertToTryWithResources")
    public String verificarCupoFutbol(){
        this.setEstadoF("inscribir");
        this.deporte = "futbol";
        this.escribirDeporte();
        this.setCantJugadores(cantidadLineas());
        if(cantJugadores < 10)
            return SUCCESS;
        else{
            addActionError("--- FÚTBOL ---");
            addActionError("Lo sentimos, NO se permiten más inscripciones por lo que se alcanzó el cupo máximo de 10");
        }
        return ERROR;
    }
    
    /* Contabilizo la cantidad de jugadores inscriptos en deporte basquet  */
    @SuppressWarnings("ConvertToTryWithResources")
    public String verificarCupoBasquet(){
        this.setEstadoF("inscribir");
        this.deporte = "basquet";
        this.escribirDeporte();
        this.setCantJugadores(cantidadLineas());
        if(cantJugadores < 10)
            return SUCCESS;
        else{
            addActionError("--- BASQUET ---");
            addActionError("Lo sentimos, NO se permiten más inscripciones por lo que se alcanzó el cupo máximo de 10");
        }
        return ERROR;
    }
    
    /* Contabilizo la cantidad de jugadores inscriptos en deporte voley */
    @SuppressWarnings("ConvertToTryWithResources")
    public String verificarCupoVoley(){
        this.setEstadoF("inscribir");
        this.deporte = "voley";
        this.escribirDeporte();
        this.setCantJugadores(cantidadLineas());
        if(cantJugadores < 12)
            return SUCCESS;
        else{
            addActionError("--- VÓLEY ---");
            addActionError("Lo sentimos, NO se permiten más inscripciones por lo que se alcanzó el cupo máximo de 12");
        }
        return ERROR;
    }
    
    /* Contabilizo la cantidad de jugadores inscriptos en deporte paddle */
    @SuppressWarnings("ConvertToTryWithResources")
    public String verificarCupoPaddle(){
        this.setEstadoF("inscribir");
        this.deporte = "paddle";
        this.escribirDeporte();
        this.setCantJugadores(cantidadLineas());
        if(cantJugadores < 4)
            return SUCCESS;
        else{
            addActionError("--- PADDLE ---");
            addActionError("Lo sentimos, NO se permiten más inscripciones por lo que se alcanzó el cupo máximo de 4");
        }
        return ERROR;
    }
    
    public String verLista(){
        this.setEstadoF("verLista");
        this.actualizarListaAux();
        return SUCCESS;
    }
    
    /* Actualiza la lista de jugadores */
    public String actualizarLista(){
        this.actualizarListaAux();
        return SUCCESS;
    }
    
    /* Rellena la lista con el contenido que se encuentra en el archivo */
    @SuppressWarnings({"Convert2Diamond", "ConvertToTryWithResources"})
    private void actualizarListaAux(){
        try{
            File f = this.obtenerArchivo();
            
            this.jugadores = new ArrayList<Jugador>();
            
            if(f.exists()){
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String linea;
                while((linea = br.readLine()) != null){
                    String [] jugadorDatos = linea.split(" ");
                    Jugador j = new Jugador(jugadorDatos[0], jugadorDatos[1], jugadorDatos[2]);
                    this.jugadores.add(j);
                }
                br.close();
                fr.close();
            }
        }catch(IOException e){
        }
    }
    
    /* Retorna la cantidad de lineas que contiene el archivo de texto (cantidad de jugadores) */
    @SuppressWarnings("ConvertToTryWithResources")
    private int cantidadLineas(){
        int cantidad = 0;
        try{
            File f = this.obtenerArchivo();
            
            if(f.exists()){
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                
                while((br.readLine()) != null){
                    cantidad++;
                }
                br.close();
                fr.close();
                return cantidad;
            }
        }catch (IOException e){
        }
        return cantidad;
    }
    
    /* Escribe (guarda) el nombre del deporte en un archivo de texto */
    public String escribirDeporte(){
        try {
            
            File f = new File(ServletActionContext.getServletContext().getRealPath("/"),"Deporte.txt");
                
            FileWriter fw;
            fw = new FileWriter(f);
            BufferedWriter bw;
            bw = new BufferedWriter(fw);
            
            bw.write(this.deporte);
            
            bw.close();
            fw.close();
            
        } catch (IOException e) {
        }
        return SUCCESS;
    }
    
    /* Recupero el nombre del deporte almacenado en el archivo de texto */
    private String obtenerDeporte(){
        String aRet = "";
        try {
            
            File f = new File(ServletActionContext.getServletContext().getRealPath("/"),"Deporte.txt");
                
            FileReader fr;
            fr = new FileReader(f);
            BufferedReader br;
            br = new BufferedReader(fr);
            
            aRet = br.readLine();
       
            br.close();
            fr.close();
            
        } catch (IOException e) {
        }
        return aRet;
    }
    
    /* Obtengo el archivo del deporte seleccionado (Futbol, Basquet, Voley, Paddle) */
    private File obtenerArchivo(){
        this.deporte = obtenerDeporte();
            File f = null;
            switch (deporte) {
                case "futbol":
                    f = new File(ServletActionContext.getServletContext().getRealPath("/"),"Futbol.txt");
                    this.setMaxCantidadJugadores(10);
                    break;
                case "basquet":
                    f = new File(ServletActionContext.getServletContext().getRealPath("/"),"Basquet.txt");
                    this.setMaxCantidadJugadores(10);
                    break;
                case "voley":
                    f = new File(ServletActionContext.getServletContext().getRealPath("/"),"Voley.txt");
                    this.setMaxCantidadJugadores(12);
                    break;
                case "paddle":
                    f = new File(ServletActionContext.getServletContext().getRealPath("/"),"Paddle.txt");
                    this.setMaxCantidadJugadores(4);
                    break;
                default:
                    break;
            }
            return f;
    }
    
    /* Si la cantidad de jugadores inscriptos es igual a la cantidad máxima de jugadores, 
       da por terminado el partido y la lista de jugadores se vacía, y queda preparada 
       para un próximo partido */
    public String darBajaPartido(){
        String ir = ERROR;
        try {
            this.cantJugadores = cantidadLineas();
            
            File f = this.obtenerArchivo();

            if(f.exists() ){
                if(cantJugadores == maxCantidadJugadores){
                    FileWriter fw;
                    fw = new FileWriter(f);
                    BufferedWriter bw;
                    bw = new BufferedWriter(fw);
                    addActionMessage("El partido se dio de baja exitosamente");
                    ir = SUCCESS;
                    bw.write("");
                    bw.close();
                    fw.close();
                }else
                    if(cantJugadores == 0)
                        addActionError("ERROR: La lista de jugadores está vacia");
                    else
                        addActionError("ERROR: La lista de jugadores aún no se llena");                
            }else
                addActionError("ERROR: No hay jugadores inscriptos");
            
        } catch (IOException e) {
        }
        this.estadoF = ir;
        return ir;
    }

}