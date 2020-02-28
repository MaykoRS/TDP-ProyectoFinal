package ActionClass;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

/**
 * @author Mayko Rodríguez - LU: 109130, alumno de la Universidad Nacional del Sur
 */

public class Usuario extends ActionSupport implements SessionAware {
    private String useradmin;
    private String userpwd;
    
    private SessionMap<String, Object> session;

    
    @Override
    public String execute(){
        String ir=ERROR; //error
        if(getUseradmin().equals("admin") &&  getUserpwd().equals("password")){
            addActionMessage("Bienvenido Administrador!! :) ");
            ir=SUCCESS; //success
            this.session.put("USER", "ADMIN");
        }
        else{
            if(getUseradmin().equals("") && getUserpwd().equals("")){
                addActionError("Por favor ingrese usuario y contraseña");
            }
            else{
                addActionError("Usuario o contraseña incorrecta :( ");
            }
        }
        return ir;
    }
    
    /* Cierra sesión */
    public String logOut(){
        if(this.session != null){
            this.session.invalidate();
        }
        return SUCCESS;
    }
    
    /**
     * @return the userlogin
     */
    public String getUseradmin() {
        return useradmin;
    }

    /**
     * @param useradmin the userlogin to set
     */
    public void setUserlogin(String useradmin) {
        this.useradmin = useradmin;
    }

    /**
     * @return the userpwd
     */
    public String getUserpwd() {
        return userpwd;
    }

    /**
     * @param userpwd the userpwd to set
     */
    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = (SessionMap)map;
    }
}