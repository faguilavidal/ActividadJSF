package BLL;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;


/**
 *
 * @author fabian
 */
@ManagedBean

public class Login 
{
    private String username;
    private String password;
    private String email;
    
    public Login() 
    {
        
    }
    
    public Login(String username, String password,String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void login(ActionEvent event)
    {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage mensaje = null;
        boolean loggedIn = false;
        
        if(username != null && password != null)
        {
            BLL.Login user = new DAL.Login().selectUsuario(username, password);
            
            if(user != null && username.equals(user.getUsername()) && password.equals(user.getPassword()))
            {
                loggedIn = true;
                mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"Bienvenido",username);
            }
            else
            {
                loggedIn = false;
                mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error de login","Ingreso no valido");
            }
        }
        else
        {
            loggedIn = false;
            mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error de login","Ingreso no valido");
        }
        
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
        context.addCallbackParam("loggedIn", loggedIn);
    }
    
    public void registro(ActionEvent event)
    {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage mensaje = null;
        boolean loggedIn = false;
        
        if(username != null && password != null)
        {
            Login l = new Login(username,password,email);
            
            new DAL.Login().insertUsuario(l);
            
            loggedIn = true;
            mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"Registrado",username);
            
        }
        else
        {
            loggedIn = false;
            mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error de login","Ingreso no valido");
        }
        
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
        context.addCallbackParam("loggedIn", loggedIn);
    }
}

